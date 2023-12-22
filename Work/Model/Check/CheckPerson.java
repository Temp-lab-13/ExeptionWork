package Work.Model.Check;

import Work.Model.SaveFile.Writable;

public class CheckPerson {

    public boolean checkPersona(String persona, String path) {
        Writable writable = new Writable();
        try {
            String[] list = writable.readFile(path).split("\n");

            for (int i = 0; i < list.length; i++) {

                if (list[i].equals(persona)) {
                    System.out.println("Запись указанного персонажа уже сделана.");
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            System.out.println("Такого файла ещё нет");
            return true;
        }
    }

}
