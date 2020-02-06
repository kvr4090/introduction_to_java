package tasks.homelibrary.users;

import tasks.homelibrary.resource.Book;
import tasks.homelibrary.resource.MailClass;

import java.io.IOException;
import java.util.ArrayList;

public class Admin extends User {

    public Admin() {
    }

    public ArrayList<Book> addBook(ArrayList<Book> listBook, ArrayList<User> listUsers, Admin admin) throws IOException {
        Book book = new Book();
        listBook.add(book);
        String emailPassword = getEmailPassword();

        for (User current : listUsers) {
            new MailClass(admin.getEmail(), emailPassword, current.getEmail(),"Уважаемый " + current.getEmail() +
                    " в библиотеку добавлена новая книга: " + book.toString(),"Обновление библиотеки");
        }
        return listBook;
    }

    public ArrayList<Book> removeBook(ArrayList<Book> list, Book book) {
        list.removeIf(current -> current.getAuthor().equals(book.getAuthor()) &&
                current.getTitle().equals(book.getTitle()) &&
                current.getCountPages() == book.getCountPages() &&
                current.getDirectory().equals(book.getDirectory()) &&
                current.isPaper() == book.isPaper());
        return list;
    }
}
