import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class GitWatcherApp {

    // Дефолтна папка для моніторингу твоїх практик
    private static final String DEFAULT_DIR = System.getProperty("user.home") + "/MyProject/practice";
    private static final String EDITOR = "cursor"; 

    public static void main(String[] args) {
        Path scanDir = Paths.get(args.length > 0 ? args[0] : DEFAULT_DIR);

        if (!Files.exists(scanDir) || !Files.isDirectory(scanDir)) {
            System.err.println("Error: Directory '" + scanDir + "' does not exist.");
            System.exit(1);
        }

        GitScannerService scannerService = new GitScannerService();
        RofiUiService uiService = new RofiUiService(EDITOR);

        List<Path> repoPaths = scannerService.findGitRepositories(scanDir);
        if (repoPaths.isEmpty()) {
            uiService.showMenu(List.of("No Git repositories found in: " + scanDir));
            return;
        }

        Map<Path, RepoStatus> results = scannerService.scanAllRepositories(repoPaths);

        // Сортуємо: спочатку проблемні
        List<RepoStatus> sortedStatuses = results.values().stream()
                .sorted((r1, r2) -> Boolean.compare(
                        r2.hasUncommitted() || r2.hasUnpushed(), 
                        r1.hasUncommitted() || r1.hasUnpushed()
                ))
                .toList();

        List<String> rofiLines = sortedStatuses.stream()
                .map(RepoStatus::toRofiLine)
                .toList();

        String selectedLine = uiService.showMenu(rofiLines);

        if (selectedLine != null && !selectedLine.isBlank()) {
            sortedStatuses.stream()
                    .filter(status -> selectedLine.contains(status.getRepoName()))
                    .findFirst()
                    .ifPresent(status -> uiService.openInEditor(status.path()));
        }
    }
}
