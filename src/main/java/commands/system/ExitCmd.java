package commands.system;

import commands.ICommand;

public class ExitCmd implements ICommand {
    private static final String sCommendName = "Exit";

    @Override
    public void execute() {
        System.exit(0);
    }

    @Override
    public String toString() {
        return sCommendName;
    }
}
