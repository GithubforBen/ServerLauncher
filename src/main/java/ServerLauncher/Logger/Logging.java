package ServerLauncher.Logger;

import ServerLauncher.Logger.Priority.Priority;
import ServerLauncher.Main;

import java.util.Date;

public class Logging {

    //creates a Log and prepares to save him
    public void createLog(String logInput, Priority priority) {
        //generate Log
        Log log = new Log() {
            @Override
            public Date date() {
                return new Date();
            }

            @Override
            public String message() {
                return logInput;
            }

            @Override
            public Priority priority() {
                return priority;
            }

            @Override
            public String fullString() {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("[").append(date()).append("]").append(" ").append(message());
                return stringBuilder.toString();
            }
        };
        //adds log to the Log List
        Main.getInstance().getSaveLogs().getLogs().add(log);
        //tries to send the message to the chat
        if (Main.getInstance().getGenPriority().shouldSend(priority)) {
            System.out.println(log.fullString());
        }
    }
}
