package classes.task3;

/*
 * Создайте класс с именем Student, содержащий поля: фамилия и инициалы, номер группы, успеваемость (массив
 * из пяти элементов). Создайте массив из десяти элементов такого типа. Добавьте возможность вывода фамилий и
 * номеров групп студентов, имеющих оценки, равные только 9 или 10.
 */

public class Student {
    private String surname;
    private int numberGroup;
    private int [] progress;

    public Student(String surname, int numberGroup) {
        this.surname = surname;
        this.numberGroup = numberGroup;
    }

    public void setProgress(int[] progress) {
        int temp = 0;

        if (progress.length != 5) {
            System.out.println("Ошибка длинны массива успеваемость. Массив не приянт.");
        } else {
            for (int score : progress) {
                if (score >= 0) {
                    temp++;
                }
            }

            if (temp == 5) {
                this.progress = progress;
            } else {
                System.out.println("Отрицательная оценка в успеваемости. Массив не принят.");
            }
        }
    }

    public void toScreenGoodStudents(Student[] students) {
        int count;

        for (Student student : students) {
            count = 0;

            for (int j = 0; j < student.progress.length; j++) {
                if (student.progress[j] >= 9) {
                    count++;
                }
            }

            if (count == 5) {
                System.out.println(student.surname + "\t" + student.numberGroup + " группа");
            }
        }
    }

    public static void main(String[] args) {
        Student[] students = new Student[10];
    }
}

