package Work.Model.Check;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/*
 * Класс содержащий проверки и больше ничего не делает.
 * Каждая проверка возращает лишь true or false.
 */
public class CheckDate {
    // Конструктор заглушка.
    public CheckDate() {

    }

    /*
     * Метод проверяет, что массив заполнен.
     */
    public boolean checkNullRecord(String[] array) {
        if (array.length > 4 | array.length < 4) {
            System.out.println("Не все поля заполнены.");
            return false;
        }
        for (String element : array) {
            if (element == null) {
                return false;
            }
        }
        return true;
    }

    /*
     * Ищем в переданном массиве элемент состоящий исключительно букв.
     * Не учитывает порядок ввода ФИО и адекватность самих слов.
     * Не учитывает смешивание кириллицы и латиницы.
     */
    public int checkName(String[] name) {

        for (int i = 0; i < name.length; i++) {
            if (name[i].matches("[а-я А-Яa-zA-Z]+")) {
                return i;
            }
        }
        System.out.println("Не корректно заполнено ФИО");
        return -1;
    }

    /*
     * Проверяет правильность формата введёной даты для парсинга.
     * Проверяет реалистичность даты с использованием текущей локальной даты.
     * Ситуация, когда комп живёт в 1900 году не учитывается. .
     */

    public boolean checkDate(String date, DateTimeFormatter format) {
        try {
            LocalDate time = LocalDate.now();
            LocalDate trueDate = LocalDate.parse(date, format);

            if (trueDate.getDayOfMonth() > 31 | trueDate.getDayOfMonth() < 1
                    | trueDate.getMonthValue() < 1 | trueDate.getMonthValue() > 12
                    | trueDate.getYear() > time.getYear() | trueDate.getYear() < (time.getYear() - 150)) {
                return false;
            } else {
                return true;
            }

        } catch (RuntimeException ex) {
            return false;
        }
    }

    public int searchAndCheckDates(String[] date, DateTimeFormatter format) {
        for (int i = 0; i < date.length; i++) {
            if (checkDate(date[i], format)) {
                return i;
            }
        }
        System.out.println("Не корректно заполнена дата рождения.");
        return -1;
    }

    /*
     * Номер проверяется только на соответсвие наличию цифрам.
     * Так как не известно, какой длины может быть номер.
     * Если проверку проходим, то получаем
     */
    public int checkTel(String[] tel) {
        for (int i = 0; i < tel.length; i++) {
            if (tel[i].matches("[0-9\\+]+")) {
                return i;
            }
        }
        System.out.println("Не корректно введён номер телефона.");
        return -1;
    }

    public int checkGender(String[] gender) {
        for (int i = 0; i < gender.length; i++)
            if (gender[i].matches("[mMfF]")) {
                return i;
            }
        System.out.println("Не корректно указан пол пользователя.");
        return -1;
    }

}
