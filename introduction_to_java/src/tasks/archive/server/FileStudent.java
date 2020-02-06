package tasks.archive.server;

/*
 * Задание 3: создайте клиент-серверное приложение “Архив”.
 * Общие требования к заданию:
 * В архиве хранятся Дела (например, студентов). Архив находится на сервере.
 * Клиент, в зависимости от прав, может запросить дело на просмотр, внести в
 * него изменения, или создать новое дело.
 * Требования к коду лабораторной работы:
 * Для реализации сетевого соединения используйте сокеты.
 * Формат хранения данных на сервере – xml-файлы.
 */

public class FileStudent {
    private String numberOwner;
    private String text;

    public FileStudent() {
    }

    public FileStudent(String numberOwner, String text) {
        this.numberOwner = numberOwner;
        this.text = text;
    }

    public String getNumberOwner() {
        return numberOwner;
    }

    public void setNumberOwner(String numberOwner) {
        this.numberOwner = numberOwner;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Дело студента: " +
                "Номер студента: '" + numberOwner + '\'' +
                ", Сведения о студенте: '" + text + '\'';
    }
}
