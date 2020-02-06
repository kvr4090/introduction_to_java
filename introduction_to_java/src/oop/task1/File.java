package oop.task1;

public class File {

    private String name;
    private Directory directory;

    public File(String name, Directory directory) {
        this.name = name;
        this.directory = directory;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void deleteFile() {
        name = null;
        directory = null;
    }
}
