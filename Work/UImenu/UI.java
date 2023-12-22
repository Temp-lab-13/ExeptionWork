package Work.UImenu;

import java.util.Scanner;

import Work.Model.DataEnter.DateEnter;
import Work.Presentor.Presenror;
import Work.UImenu.InputCheck.ConvertEnter;
import Work.UImenu.MainConsole.MainConsole;

public class UI implements View {
    private Presenror presenror;
    private MainConsole menu;

    private Scanner scanner;

    private boolean flag = true;
    private String userEnter;

    // Для старго метода.
    private DateEnter persone;

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

    /*
     * Старый метод меню.
     */
    public void start() {
        try (Scanner scanner = new Scanner(System.in, "Cp866")) {
            while (flag) {

                System.out.println("Menu: \n");
                System.out.println("New: сделать новую запись;");
                System.out.println("Save: сохранить запись в файл;");
                System.out.println("Load: загрузить файл;");
                System.out.println("End: завершить работу. \n");
                switch (scanner.nextLine().toLowerCase()) {
                    case "new":
                        System.out.println(
                                "Введите разделив запятой и пробелом : ФИО, дату рождения(dd.mm.yyyy), номер телефона(89997776666), пол(f/m)");
                        userEnter = scanner.nextLine();
                        String pers = persone.enter(userEnter);
                        System.out.println(pers);

                        scanner.nextLine();
                        break;
                    case "save":
                        persone.save();
                        scanner.nextLine();
                        break;
                    case "load":
                        System.out.println("Укажите название файла");
                        System.out.println(persone.Load(scanner.nextLine()));
                        scanner.nextLine();
                        break;
                    case "end":
                        flag = false;
                        break;
                    default:
                        System.out.println("Не корректная команда.");
                        scanner.nextLine();
                        break;
                }
            }
        } catch (Exception ex) {
            System.out.println("Критическая ошибка ввода: \n" + ex.getStackTrace());
        }

    }
}