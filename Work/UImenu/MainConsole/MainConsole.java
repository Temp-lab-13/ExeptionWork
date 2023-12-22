package Work.UImenu.MainConsole;

import java.util.ArrayList;
import java.util.List;

import Work.UImenu.View;
import Work.UImenu.MainConsole.CommandsConsole.Commands;
import Work.UImenu.MainConsole.CommandsConsole.ListCommads.Exit;
import Work.UImenu.MainConsole.CommandsConsole.ListCommads.LoadFile;
import Work.UImenu.MainConsole.CommandsConsole.ListCommads.SaveFile;
import Work.UImenu.MainConsole.CommandsConsole.ListCommads.UserEnter;

public class MainConsole {

    private List<Commands> commandList;

    public MainConsole(View ui) {
        commandList = new ArrayList<>();
        commandList.add(new UserEnter(ui));
        commandList.add(new SaveFile(ui));
        commandList.add(new LoadFile(ui));
        commandList.add(new Exit(ui));
    }

    public String print() {
        StringBuilder listCommand = new StringBuilder();
        listCommand.append("Command: ");
        listCommand.append("\n");
        for (int i = 0; i < commandList.size(); i++) {
            listCommand.append(i + 1);
            listCommand.append(": ");
            listCommand.append(commandList.get(i).getDescription());
            listCommand.append("\n");
        }
        return listCommand.toString();
    }

    public void execute(int numberCommand) {
        Commands commands = commandList.get(numberCommand - 1);
        commands.execute();
    }

    public int size() {
        return commandList.size();
    }

}
