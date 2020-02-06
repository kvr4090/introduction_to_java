package oop.task1;

/*
 * Создать объект класса Текстовый файл, используя классы Файл, Директория. Методы: создать, переименовать,
 * вывести на консоль содержимое, дополнить, удалить.
 */

public class TextFile extends File{

    private String text;

    public TextFile(String name, Directory directory, String text) {
        super(name, directory);
        this.text = text;
    }

    public void toScreen() {
        System.out.println(text);
    }

    public void addText(String newText) {
        text = text.concat(newText);
    }

    @Override
    public void deleteFile() {
        super.deleteFile();
        text = null;
    }

    public static void main(String[] args) {
        TextFile text = new TextFile("document",new Directory("C:\\document.txt"),"my dream");
    }
}
