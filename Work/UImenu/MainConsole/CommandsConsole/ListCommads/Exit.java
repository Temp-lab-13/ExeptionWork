package Work.UImenu.MainConsole.CommandsConsole.ListCommads;

import Work.UImenu.View;
import Work.UImenu.MainConsole.CommandsConsole.Commands;

public class Exit extends Commands {

    public Exit(View ui) {
        super("Завершить работу приложения.", ui);
    }

    public void execute() {
        getView().exit();
    }

}
