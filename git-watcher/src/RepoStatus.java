import java.nio.file.Path;

public record RepoStatus(Path path, boolean hasUncommitted, boolean hasUnpushed, String error) {
    
    public String getRepoName() {
        return path.getFileName().toString();
    }

    public String toRofiLine() {
        if (error != null) {
            return "[Error] " + getRepoName() + " -> " + error;
        }
        if (hasUncommitted && hasUnpushed) {
            return "[X] " + getRepoName() + " (Uncommitted changes & Unpushed commits)";
        }
        if (hasUncommitted) {
            return "[!] " + getRepoName() + " (Uncommitted changes)";
        }
        if (hasUnpushed) {
            return "[^] " + getRepoName() + " (Unpushed commits)";
        }
        return "[*] " + getRepoName() + " (Clean)";
    }
}
