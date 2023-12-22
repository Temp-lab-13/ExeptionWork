package Work.UImenu;

import java.util.Scanner;
import Work.Presentor.Presenror;
import Work.UImenu.InputCheck.ConvertEnter;
import Work.UImenu.MainConsole.MainConsole;

public class UI implements View {
    private Presenror presenror;
    private MainConsole menu;

    private Scanner scanner;

    private boolean flag = true;
    private String userEnter;

    public UI() {
        presenror = new Presenror(this);
        menu = new MainConsole(this);
        scanner = new Scanner(System.in, "Cp866");
    }

    public void starts() {
        while (flag) {
            cataligCommands();
            consoleWork();
        }
        scanner.close();
    }

    public void answer(String answer) {
        System.out.println(answer);
    }

    public void cataligCommands() {
        System.out.println(menu.print());
    }

    public void consoleWork() {
        System.out.println("Ввод команды: ");
        userEnter = scanner.nextLine();
        ConvertEnter convertEnter = new ConvertEnter(userEnter, menu.size());
        Integer enter = convertEnter.convertEnter();
        if (enter != null) {
            menu.execute(enter);
        }
    }

    public void enter() {
        System.out.println("Введите разделив запятой и пробелом: ");
        System.out.println("ФИО, дату рождения(dd.ММ.yyyy), номер телефона(89997776666), пол(f/m)");
        userEnter = scanner.nextLine();

        presenror.enter(userEnter);
    }

    public void save() {
        presenror.save();
    }

    public void load() {
        System.out.println("Введите название загружаемого файла: ");
        userEnter = scanner.nextLine();
        presenror.load(userEnter);
    }

    public void exit() {
        flag = presenror.exit();
    }

}