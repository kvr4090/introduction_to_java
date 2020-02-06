package tasks.homelibrary.users;

import tasks.homelibrary.resource.Book;
import tasks.homelibrary.resource.MailClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
    private String email;
    private String password;

    public User() {
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String userName, ArrayList<User> listUsers) throws Exception {
        System.out.println(userName + ", Добро пожаловать в домашнюю библиотеку!");
        setWithUserEmail(listUsers);
        setWithUserPassword();
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setWithUserPassword () throws IOException {
        System.out.println("Введите пароль: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String temp = reader.readLine();

        if (temp.equals("")) {
            System.out.println("Пустая строка!");
            setWithUserPassword();
        } else {
            Pattern pattern = Pattern.compile(".{6,}");
            Matcher matcher = pattern.matcher(temp);

            if (matcher.find()) {
                password = temp;
            } else {
                System.out.println("Слишком короткий пароль, придумайте другой.");
                setWithUserPassword();
            }
        }
    }

    public void setWithUserEmail(ArrayList<User> listUsers) throws Exception {
        System.out.println("Введите адрес вашей электронной почты: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String emailUser = reader.readLine();

        if (emailUser.equals("")) {
            System.out.println("Пустая строка!");
            setWithUserEmail(listUsers);
        } else {
            Pattern pattern = Pattern.compile("^[A-z0-9._%+-]+@[A-z0-9.-]+\\.[A-z]{2,6}$");
            Matcher matcher = pattern.matcher(emailUser);

            if (matcher.find()) {
                if (listUsers.size() == 0){
                    email = emailUser;
                }
                for (User current : listUsers) {
                    if (emailUser.equals(current.getEmail())) {
                        System.out.println("Введённый адрес электронной почты уже занят.");
                        setWithUserEmail(listUsers);
                        break;
                    } else {
                        email = emailUser;
                    }
                }
            } else {
                System.out.println("Несуществующий адрес электронной почты.");
                setWithUserEmail(listUsers);
            }
        }
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getEmailPassword() throws IOException {
        System.out.println("Для отправления письма, введите пароль от электронной почты:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String temp = reader.readLine();

        if (temp.equals("")) {
            System.out.println("Пустая строка!");
            getEmailPassword();
        } else {
            return temp;
        }
        return temp;
    }

    public void browseLibrary(ArrayList<Book> listBooks) throws IOException {
        if (listBooks.size() == 0) {
            System.out.println("Каталог книг пуст!");
        } else {
            toScreenOnePage(0, listBooks);
        }
    }

    private void toScreenOnePage(int temp, ArrayList<Book> list)throws IOException {
        int j = temp * 30;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        if ((list.size() % 30) == 0) {
            for (int i = j; i < j + 30; i++) {
                System.out.println(list.get(i).toString());
            }

            if (temp == ((list.size() / 30) - 1)) {
                System.out.println("Конец каталога книг.");
            } else {
                if (reader.readLine().equals("")) {
                    temp++;
                    toScreenOnePage(temp, list);
                }
            }
        } else {
            if (temp == (list.size() / 30)) {
                for (int i = j; i < j + (list.size() % 30); i++) {
                    System.out.println(list.get(i).toString());
                }
                System.out.println("Конец каталога книг.");

            } else {
                for (int i = j; i < j + 30; i++) {
                    System.out.println(list.get(i).toString());
                }

                if (reader.readLine().equals("")) {
                    temp++;
                    toScreenOnePage(temp, list);
                }
            }
        }
    }

    public void searchBookWithAuthor(ArrayList<Book> listBooks) throws IOException {
        System.out.println("Введите автора книги:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String authorName = reader.readLine();

        if (authorName.equals("")) {
            System.out.println("Пустая строка!");
            searchBookWithAuthor(listBooks);
        } else {
            int count = 0;
            Pattern pattern = Pattern.compile("[A-zА-я\\s]");
            Matcher matcher = pattern.matcher(authorName);

            if (matcher.find()) {
                for (Book current : listBooks) {
                    if (current.getAuthor().equals(authorName)) {
                        System.out.println(current.toString());
                        count++;
                    }
                }
            } else {
                System.out.println("Неправльное имя!");
                searchBookWithAuthor(listBooks);
            }

            if (count == 0) {
                System.out.println("Такого автора в каталоге книг нет.");
            }
        }
    }

    public void searchBookWithTitle(ArrayList<Book> list) throws IOException {
        System.out.println("Введите название книги:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String bookTitle = reader.readLine();

        if (bookTitle.equals("")) {
            System.out.println("Пустая строка!");
            searchBookWithTitle(list);
        } else {
            int count = 0;
            Pattern pattern = Pattern.compile("[А-яA-z0-9\\s.,!:]");
            Matcher matcher = pattern.matcher(bookTitle);

            if (matcher.find()) {
                for (Book current : list) {
                    if (current.getTitle().equals(bookTitle)) {
                        System.out.println(current.toString());
                        count++;
                    }
                }
            } else {
                System.out.println("Неправильное название!");
                searchBookWithTitle(list);
            }

            if (count == 0) {
                System.out.println("Такой книги в каталоге нет!");
            }
        }
    }

    public void searchBookWithAuthorAndTitle(ArrayList<Book> listBook) throws IOException {
        int count = 0;
        Book book = new Book("crutch");

        for (Book current : listBook) {
            if (current.getTitle().equals(book.getTitle()) && current.getAuthor().equals(book.getAuthor())) {
                System.out.println(current.toString());
                count++;
            }
        }

        if (count == 0) {
            System.out.println("Этой книги в каталоге нет!");
        }
    }

    public void userOfferBook(Admin admin, User user) throws IOException {
        Book book = new Book();

        if (book.isPaper()) {
            new MailClass(user.getEmail(), getEmailPassword(), admin.getEmail(), "Пользователь " +
                    user.getEmail() + " предлагает добавить эту книгу в библиотеку " +
                    book.toString(),"Предложение добавить книгу в библиотеку.");
        } else {
            new MailClass(user.getEmail(), getEmailPassword(), admin.getEmail(), "Пользователь " +
                    user.getEmail() + " предлагает добавить эту книгу в библиотеку " +
                    book.toString(),"Предложение добавить книгу в библиотеку.", book.getDirectory());
        }
    }
}
