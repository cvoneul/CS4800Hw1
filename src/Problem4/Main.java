package Problem4;

public class Main {
    public static void main(String[] args) {
        Folder folder1 = new Folder("demo1");
        Folder subfolder1 = new Folder("source files");
        Folder subfolder2 = new Folder("include path");
        Folder subfolder3 = new Folder("remote files");
        Folder subSubfolder1 = new Folder("phalcon");
        Folder subSubfolder2 = new Folder("app");
        Folder subSubfolder3 = new Folder("cache");
        Folder subSubfolder4 = new Folder("public");
        File file1 = new File("htaccess");
        File file2 = new File("htrouter.php");
        File file3 = new File("index.html");
        Folder subSubSubfolder1 = new Folder("config");
        Folder subSubSubfolder2 = new Folder("controllers");
        Folder subSubSubfolder3 = new Folder("library");
        Folder subSubSubfolder4 = new Folder("migrations");
        Folder subSubSubfolder5 = new Folder("models");
        Folder subSubSubfolder6 = new Folder("views");


        folder1.addFolder(subfolder1);
        folder1.addFolder(subfolder2);
        folder1.addFolder(subfolder3);

        subfolder1.addFolder(subSubfolder1);
        subfolder1.addFolder(subSubfolder2);
        subfolder1.addFolder(subSubfolder3);
        subfolder1.addFolder(subSubfolder4);
        subfolder1.addFile(file1);
        subfolder1.addFile(file2);
        subfolder1.addFile(file3);

        subSubfolder2.addFolder(subSubSubfolder1);
        subSubfolder2.addFolder(subSubSubfolder2);
        subSubfolder2.addFolder(subSubSubfolder3);
        subSubfolder2.addFolder(subSubSubfolder4);
        subSubfolder2.addFolder(subSubSubfolder5);
        subSubfolder2.addFolder(subSubSubfolder6);

        subfolder1.deleteFolder("app");
        subfolder1.deleteFolder("public");

        //folder1.printAllSubFoldersAndFiles();
        folder1.printTree(0);
    }
}
