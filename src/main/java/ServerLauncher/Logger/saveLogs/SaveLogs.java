package ServerLauncher.Logger.saveLogs;

import ServerLauncher.Logger.Log;
import ServerLauncher.Logger.Priority.Priority;
import ServerLauncher.Main;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SaveLogs {
    //The List containing all Logs
    List<Log> logs = new ArrayList<>();
    File file;

    //generates file
    public SaveLogs() {
        Date dateI = new Date();
        String date = String.valueOf(dateI);
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : date.split(" ")) {
            stringBuilder.append(s);
        }
        file = new File("./Logs/" + stringBuilder.toString() + ".txt");
        if (!file.exists()) {
            File file1 = new File("./Logs");
            if (!file1.exists()) {
                file1.mkdirs();
            }
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Log> getLogs() {
        return logs;
    }

    //saves the Logs
    public void save() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Log log : logs) {

            stringBuilder
                    .append("[").append(" Priority: ").append(log.priority().toString()).append(", ")
                    .append(log.date()).append("]").append(" ")
                    .append(log.message())
                    .append("\n");
        }
        try {
            OutputStream outputStream = new FileOutputStream(file);
            outputStream.write(stringBuilder.toString().getBytes(StandardCharsets.UTF_8));
            outputStream.close();
        } catch (IOException e) {
            Main.getInstance().getLogging().createLog(e.toString(), Priority.DEBUG);
        }
    }
}
