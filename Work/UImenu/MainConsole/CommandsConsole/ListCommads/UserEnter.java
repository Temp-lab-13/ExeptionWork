package Work.UImenu.MainConsole.CommandsConsole.ListCommads;

import Work.UImenu.View;
import Work.UImenu.MainConsole.CommandsConsole.Commands;

public class UserEnter extends Commands {

    public UserEnter(View ui) {
        super("Ввести данные;", ui);
    }

    public void execute() {
        getView().enter();
    }

}
