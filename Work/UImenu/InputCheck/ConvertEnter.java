package Work.UImenu.InputCheck;

public class ConvertEnter {

    private String element;
    private int size;

    // Конструктор.
    public ConvertEnter(String input, int size) {
        this.element = input;
        this.size = size;
    }

    // Возращаем преобразованую в число команду или пустоту.
    public Integer convertEnter() {
        if (checkNumber()) {
            Integer number = convertString();
            if (checkOption(number, size)) {
                return number;
            }
        }
        return null;
    }

    // Конвертируем строку в число.
    public Integer convertString() {
        return Integer.parseInt(element);
    }

    // Проверяем, что строка может быть преобразована в число.
    public boolean checkNumber() {
        try {
            Integer.parseInt(element);
            return true;
        } catch (Exception exception) {
            System.out.println("Ошибка ввода! Введёны не корректные символы.");
        }
        return false;
    }

    // Проверяем, что получившиеся число, соотвествует хотя бы одной имеющеймся в
    // меню команде.
    public boolean checkOption(int element, int size) {
        if (element <= 0 | element > size) {
            System.out.println("Ошибка ввода! Введена не корректный номер команды.");
            return false;
        } else {
            return true;
        }
    }

}
