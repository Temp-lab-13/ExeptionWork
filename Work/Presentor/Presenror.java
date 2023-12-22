package Work.Presentor;

import Work.Model.Service.Service;
import Work.UImenu.View;

public class Presenror {

    private View ui;
    private Service service;

    public Presenror(View ui) {
        this.ui = ui;
        service = new Service();
    }

    public void enter(String userEnter) {
        String answers = service.enter(userEnter);
        ui.answer(answers);
    }

    public void save() {
        service.save();
        ui.answer("Запись в файл произведена.");
    }

    public void load(String path) {
        String answers = service.load(path);
        ui.answer(answers);
    }

    public boolean exit() {
        ui.answer("Завершение работы... \n");
        return service.exit();

    }

}
