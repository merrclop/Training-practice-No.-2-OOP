import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.List;

public class RofiUiService {

    private final String editorCommand;

    public RofiUiService(String editorCommand) {
        this.editorCommand = editorCommand;
    }

    public String showMenu(List<String> items) {
        try {
            // Запуск стандартного rofi dmenu (працює скрізь)
            ProcessBuilder pb = new ProcessBuilder("rofi", "-dmenu", "-p", "Git Watcher", "-i");
            Process rofiProc = pb.start();

            try (var writer = rofiProc.getOutputStream()) {
                String inputData = String.join("\n", items);
                writer.write(inputData.getBytes());
                writer.flush();
            }

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(rofiProc.getInputStream()))) {
                return reader.readLine();
            }

        } catch (Exception e) {
            System.err.println("Error launching Rofi: " + e.getMessage());
        }
        return null;
    }

    public void openInEditor(Path projectPath) {
        try {
            new ProcessBuilder(editorCommand, projectPath.toString()).start();
        } catch (Exception e) {
            System.err.println("Error opening editor: " + e.getMessage());
        }
    }
}
