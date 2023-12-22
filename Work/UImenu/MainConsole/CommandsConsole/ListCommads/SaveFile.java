package Work.UImenu.MainConsole.CommandsConsole.ListCommads;

import Work.UImenu.View;
import Work.UImenu.MainConsole.CommandsConsole.Commands;

public class SaveFile extends Commands {

    public SaveFile(View ui) {
        super("Сохранить запись;", ui);
    }

    public void execute() {
        getView().save();
    }

}
