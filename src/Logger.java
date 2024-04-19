package src;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    private static final String LOG_DIR = "logs";
    private static final String LOG_FILE = LOG_DIR + File.separator + "logfile.log";

    public enum LogLevel {
        INFO, WARNING, ERROR
    }

    public static void log(String message) {
        log(message, LogLevel.INFO);
    }

    public static void log(String message, LogLevel level) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = dateFormat.format(new Date());

        String osDetails = System.getProperty("os.name") + " " +
                System.getProperty("os.arch") + " " +
                System.getProperty("os.version");

        String logMessage = formattedDate + " - " + osDetails + " - [" + level + "] " + message;

        try {
            File directory = new File(LOG_DIR);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            try (PrintWriter writer = new PrintWriter(new FileWriter(LOG_FILE, true))) {
                writer.println(logMessage);
                writer.println("--------------------------------------------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void logException(Exception exception) {
        log("Exception occurred: " + exception.getMessage(), LogLevel.ERROR);
        exception.printStackTrace();
    }
}
