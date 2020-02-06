package classes.task9;

/*
 * Создать второй класс, агрегирующий массив типа Book, с подходящими конструкторами и
 * методами. Задать критерии выбора данных и вывести эти данные на консоль.
 * Найти и вывести:
 * a) список книг заданного автора;
 * b) список книг, выпущенных заданным издательством;
 * c) список книг, выпущенных после заданного года.
 */

public class Solution {
    Book[] books;

    public Solution(Book[] books) {
        this.books = books;
    }

    public void searchAuthor(String author) {
        for (Book book : books) {
            if(book.getAuthor().equals(author)) {
                System.out.println(book.toString());
            }
        }
    }

    public void searchPublishingHouse(String publishingHouse) {
        for (Book book : books) {
            if (book.getPublishingHouse().equals(publishingHouse)) {
                System.out.println(book.toString());
            }
        }
    }

    public void searchBooksAfterYear(int year) {
        for (Book book : books) {
            if (book.getPublicationDate() > year) {
                System.out.println(book.toString());
            }
        }
    }
}
