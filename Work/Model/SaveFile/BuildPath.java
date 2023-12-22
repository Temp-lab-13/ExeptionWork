package Work.Model.SaveFile;

public class BuildPath {

    public static String buildPath(String lastNameUser) {
        StringBuilder pathBuilder = new StringBuilder();
        pathBuilder.append("Work");
        pathBuilder.append("/");
        pathBuilder.append("Model");
        pathBuilder.append("/");
        pathBuilder.append("SaveFile");
        pathBuilder.append("/");
        pathBuilder.append(lastNameUser);
        pathBuilder.append(".txt");
        System.out.println(pathBuilder.toString());
        return pathBuilder.toString();
    }
}
