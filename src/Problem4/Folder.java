package Problem4;

import java.util.ArrayList;

public class Folder {
    private String name;
    private ArrayList<File> files;
    private ArrayList<Folder> folders;

    public Folder(String name) {
        this.name = name;
        files = new ArrayList<File>();
        folders = new ArrayList<Folder>();
    }


    public void addFile(File file) {
        files.add(file);
    }
    public void addFolder(Folder folder) {
        folders.add(folder);
    }

    public void deleteFile(String name) {
        for(int i = 0; i < files.size(); i++) {
            if(files.get(i).getName() == name) {
                files.remove(i);
            }
        }
    }

    public void deleteFolder(String name) {
        for(int i = 0; i < folders.size(); i++) {
            if(folders.get(i).getName() == name) {
                folders.remove(i);
            }
        }
    }

    public void printTree(int depth) {
        String tabs = "\t";
        tabs = tabs.repeat(depth);

        System.out.println(tabs + getName());
        for(int i = 0; i < folders.size(); i++) {
            folders.get(i).printTree(depth+1);
        }
        for(int i = 0; i < files.size(); i++) {
            System.out.println(tabs + tabs + files.get(i).getName());
        }
    }

    public void setName(String newName) { name = newName; }

    public String getName() { return name; }

    public ArrayList<File> getFiles() {
        return files;
    }

    public void setFiles(ArrayList<File> files) {
        this.files = files;
    }

    public ArrayList<Folder> getFolders() {
        return folders;
    }

    public void setFolders(ArrayList<Folder> folders) {
        this.folders = folders;
    }

    public String getSubFolderName(int index) {
        return folders.get(index).name;
    }
    public void setSubFolderName(int index, String newName) {
        folders.get(index).name = newName;
    }

    public void printAllSubFoldersAndFiles() {
        for(int i = 0; i < folders.size(); i++) {
            System.out.println(getSubFolderName(i));
        }
        for(int i = 0; i < files.size(); i++) {
            System.out.println(files.get(i).getName());
        }
    }

}
