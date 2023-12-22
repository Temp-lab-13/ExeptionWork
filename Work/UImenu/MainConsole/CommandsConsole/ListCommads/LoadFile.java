package Work.UImenu.MainConsole.CommandsConsole.ListCommads;

import Work.UImenu.View;
import Work.UImenu.MainConsole.CommandsConsole.Commands;

public class LoadFile extends Commands {

    public LoadFile(View ui) {
        super("Загрузить файл;", ui);
    }

    public void execute() {
        getView().load();
    }
}
