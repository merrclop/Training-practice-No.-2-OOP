import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;

public class GitScannerService {

    public List<Path> findGitRepositories(Path startDir) {
        List<Path> repoPaths = new ArrayList<>();
        try {
            Files.walkFileTree(startDir, new SimpleFileVisitor<>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    String dirName = dir.getFileName().toString();

                    if (dirName.equals("node_modules") || dirName.equals(".gradle") || 
                        dirName.equals("target") || dirName.equals("build") || 
                        dirName.equals(".idea") || dirName.equals(".git") || dirName.equals("bin")) {
                        return FileVisitResult.SKIP_SUBTREE;
                    }

                    if (Files.exists(dir.resolve(".git"))) {
                        repoPaths.add(dir);
                        return FileVisitResult.SKIP_SUBTREE; 
                    }
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) {
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (Exception e) {
            System.err.println("Error scanning directories: " + e.getMessage());
        }
        return repoPaths;
    }

    public Map<Path, RepoStatus> scanAllRepositories(List<Path> repositories) {
        Map<Path, RepoStatus> statuses = new ConcurrentHashMap<>();
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (Path repo : repositories) {
                executor.submit(() -> {
                    RepoStatus status = checkSingleRepo(repo);
                    statuses.put(repo, status);
                });
            }
        }
        return statuses;
    }

    private RepoStatus checkSingleRepo(Path repoPath) {
        boolean uncommitted = false;
        boolean unpushed = false;
        String error = null;

        try {
            Process statusProc = new ProcessBuilder("git", "status", "--porcelain")
                    .directory(repoPath.toFile())
                    .start();
            try (var reader = new BufferedReader(new InputStreamReader(statusProc.getInputStream()))) {
                if (reader.readLine() != null) {
                    uncommitted = true;
                }
            }
            statusProc.waitFor();

            Process cherryProc = new ProcessBuilder("git", "cherry", "-v")
                    .directory(repoPath.toFile())
                    .start();
            try (var reader = new BufferedReader(new InputStreamReader(cherryProc.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.startsWith("+")) {
                        unpushed = true;
                        break;
                    }
                }
            }
            cherryProc.waitFor();

        } catch (Exception e) {
            error = e.getMessage();
        }

        return new RepoStatus(repoPath, uncommitted, unpushed, error);
    }
}
