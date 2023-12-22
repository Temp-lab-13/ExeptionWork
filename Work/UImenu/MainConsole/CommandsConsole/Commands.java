package Work.UImenu.MainConsole.CommandsConsole;

import Work.UImenu.View;

public abstract class Commands {

    private String description;
    private View ui;

    public Commands(String description, View ui) {
        this.description = description;
        this.ui = ui;
    }

    public String getDescription() {
        return description;
    }

    public View getView() {
        return ui;
    }

    public abstract void execute();

}
