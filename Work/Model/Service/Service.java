package Work.Model.Service;

import Work.Model.DataEnter.DateEnter;
import Work.Model.SaveFile.BuildPath;
import Work.Model.SaveFile.ReadLoadable;
import Work.Model.SaveFile.Writable;

public class Service {

    private DateEnter dateEnter;
    private ReadLoadable readLoad;

    public Service() {
        dateEnter = new DateEnter();
        readLoad = new Writable();
    }

    public String enter(String userEnter) {
        return dateEnter.enter(userEnter);
    }

    public void save() {
        readLoad.writeeFile(dateEnter.print(), dateEnter.getName());
    }

    public String load(String path) {
        return readLoad.readFile(BuildPath.buildPath(path));
    }

    public boolean exit() {
        return false;
    }

}
