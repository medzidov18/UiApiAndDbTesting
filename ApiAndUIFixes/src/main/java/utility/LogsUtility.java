package utility;

import lombok.SneakyThrows;
import java.nio.file.*;
import java.util.List;

import static datareadmain.DataRead.*;

public class LogsUtility {
    @SneakyThrows
    public static List<String> getLogsOfTest() {
        return Files.readAllLines(Paths.get(pathsDTO.getPathToLogFile()));
    }
}
