package Work.Model.SaveFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import Work.Model.Check.CheckPerson;

public class Writable implements ReadLoadable {

    public void writeeFile(String info, String lastName) {

        if (lastName != null & info != null) {
            String path = BuildPath.buildPath(lastName);
            CheckPerson person = new CheckPerson();
            if (person.checkPersona(info, path)) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
                    writer.write(info);
                    writer.append('\n');
                    System.out.println("Запись сделана.");
                } catch (RuntimeException | IOException ex) {
                    System.out.println("Ошибка записи: " + ex.getMessage());
                }
            }

        } else if (info == null) {
            System.out.println("Данных для записи нет.");
        } else {
            System.out.println("Не удалось сформировать путь к файлу");
        }

    }

    public String readFile(String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            StringBuilder build = new StringBuilder();
            String resalt = null;
            while ((resalt = reader.readLine()) != null) {
                build.append(resalt);
                build.append("\n");
            }
            if (build.length() > 1) {
                return build.toString();
            } else {
                return "Файл пуст";
            }

        } catch (RuntimeException | IOException ex) {
            return "Нет доступа к файлу или его не существует.";
        }
    }

}
