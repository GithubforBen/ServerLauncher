package ServerLauncher.Logger.Priority;

public class GenPriority {
    //the System priority
    private Priority priority = Priority.DEBUG;

    //returns the boolean which depends on the priority given
    public boolean shouldSend(Priority priorityI) {
        if(priority.equals(Priority.DEBUG)) {
            return true;
        }
        if (priority.equals(Priority.SERVER_LOGS)) {
            if (priorityI.equals(Priority.DEBUG)) {
                return false;
            }
        }
        if (priority.equals(Priority.NORMAL)) {
            return !priorityI.equals(Priority.DEBUG) && !priorityI.equals(Priority.SERVER_LOGS);
        }
        return true;
    }

    //function to set the System priority
    public void setPriority(String arg) {
        if (arg.equalsIgnoreCase("DEBUG")) {
            priority = Priority.DEBUG;
            return;
        }
        if (arg.equalsIgnoreCase("SERVER_LOGS")) {
            priority = Priority.SERVER_LOGS;
            return;
        }
        if (arg.equalsIgnoreCase("NORMAL")) {
            priority = Priority.NORMAL;
        }
    }

    public void setPriority(Priority priorityI) {
        priority = priorityI;
    }

    public Priority getPriority() {
        return priority;
    }
}
