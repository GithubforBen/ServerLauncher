package ServerLauncher;

import ServerLauncher.Logger.Priority.Priority;

public class Main {

    private static Instance instance;

    public static void main(String[] args) {
        instance = new Instance();
        if (args.length <= 0 || args[0].equals("help")) {
            instance.getLogging().createLog(". \n " +
                            "Help: \n " +
                            "args 0(erstes argument): \n " +
                            "Log priority [DEBUG,SERVER_LOGS,NORMAL]."
            , Priority.NORMAL);
            Instance.getInstance().stop();
            return;
        }
        instance.getGenPriority().setPriority(args[0]);
    }

    public static Instance getInstance() {
        return instance;
    }
}
