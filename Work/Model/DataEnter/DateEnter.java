package Work.Model.DataEnter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import Work.Model.Check.CheckDate;
import Work.Model.SaveFile.BuildPath;
import Work.Model.SaveFile.Writable;

public class DateEnter {
    private String[] date;
    private String name;
    // private LocalDate birthdayData;
    private String birthdayData;
    private long telethonNumber;
    private char gender;
    private CheckDate check;
    private Writable writable;
    private int resalt;
    private boolean flag;

    public DateEnter() {
        this.check = new CheckDate();
        this.writable = new Writable();
    }

    public String enter(String userDate) {

        try {
            date = userDate.split(", ");
            if (check.checkNullRecord(date)) {
                if (recordDate()) {
                    return print();
                }
            }
        } catch (Exception ex) {
            System.out.println("Критическая ошибка ввода: \n" + ex.getStackTrace());

        }
        return "Запись не была создана.";
    }

    /*
     * Метод записи полей.
     * Делает запрос на проверку данных из массива на валидности,
     * если запрос true, то конвертирует строку в нужный формат и записывает в поле
     * экземпляра класса.
     */
    public boolean recordDate() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        flag = true;
        if ((resalt = check.checkName(date)) != -1) {
            name = date[resalt];
        } else {
            flag = false;
        }

        if ((resalt = check.searchAndCheckDates(date, format)) != -1) {
            DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            try {

                Date parsedDate = dateFormat.parse(date[resalt]);
                DateFormat outputDateFormat = new SimpleDateFormat("dd.MM.yyyy");
                birthdayData = outputDateFormat.format(parsedDate);

            } catch (Exception e) {
                e.printStackTrace();
            }

            // birthdayData = LocalDate.parse(date[resalt]);

        } else {
            flag = false;
        }

        if ((resalt = check.checkTel(date)) != -1) {
            telethonNumber = Long.parseLong(date[resalt]);
        } else {
            flag = false;
        }

        if ((resalt = check.checkGender(date)) != -1) {
            gender = date[resalt].charAt(0);
        } else {
            flag = false;
        }
        return flag;
    }

    public String print() {
        StringBuilder bild = new StringBuilder();
        bild.append(name);
        bild.append(", ");
        bild.append(birthdayData);
        bild.append(", ");
        bild.append(telethonNumber);
        bild.append(", ");
        bild.append(gender);
        bild.append(";");
        return bild.toString();
    }

    public String getName() {
        String[] splitName = name.split(" ");
        return splitName[0];
    }

    public void save() {
        writable.writeeFile(print(), getName());
    }

    public String Load(String path) {
        return writable.readFile(BuildPath.buildPath(path));
    }

}
