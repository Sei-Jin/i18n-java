package i8n.util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class InputHandler {
    
    public static List<String> readAsLines(String filename) {
        try {
            return Files.readAllLines(Path.of(filename), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
