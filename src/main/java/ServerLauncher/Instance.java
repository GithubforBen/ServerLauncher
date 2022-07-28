package ServerLauncher;

import ServerLauncher.Logger.Logging;
import ServerLauncher.Logger.Priority.GenPriority;
import ServerLauncher.Logger.saveLogs.SaveLogs;

public class Instance {

    //this class is used to contain variables to access from the entire program using ServerLauncher.Main#getInstance

    //variables

    private Logging logging;
    private SaveLogs saveLogs;
    private static Instance instance;
    private GenPriority genPriority;

    //initialise variables
    public Instance() {
        instance = this;
        saveLogs = new SaveLogs();
        logging = new Logging();
        genPriority = new GenPriority();
    }

    public void stop() {
        saveLogs.save();
    }

    public Logging getLogging() {
        return logging;
    }

    public SaveLogs getSaveLogs() {
        return saveLogs;
    }

    public static Instance getInstance() {
        return instance;
    }

    public GenPriority getGenPriority() {
        return genPriority;
    }
}
