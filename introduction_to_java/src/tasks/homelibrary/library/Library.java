package tasks.homelibrary.library;

import tasks.homelibrary.resource.Book;
import tasks.homelibrary.resource.CaesarCipher;
import tasks.homelibrary.users.Admin;
import tasks.homelibrary.users.User;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Задание 1: создать консольное приложение “Учет книг в домашней библиотеке”.
 * Общие требования к заданию:
    • Система учитывает книги как в электронном, так и в бумажном варианте.
    • Существующие роли: пользователь, администратор.
    • Пользователь может просматривать книги в каталоге книг, осуществлять поиск книг в каталоге.
    • Администратор может модифицировать каталог.
    • *При добавлении описания книги в каталог оповещение о ней рассылается на e-mail всем пользователям
    • **При просмотре каталога желательно реализовать постраничный просмотр
    • ***Пользователь может предложить добавить книгу в библиотеку, переслав её администратору на e-mail.
    • Каталог книг хранится в текстовом файле.
    • Данные аутентификации пользователей хранятся в текстовом файле. Пароль не хранится в открытом виде
 */

public class Library {
    private ArrayList<Book> library;
    private ArrayList<User> users;
    private Admin admin;
    private User currentUser;

    public void run() throws Exception {
        loadLibraryFromFile();
        loadUsersFromFile();

        if (users.size() == 0) {
            System.out.println("Это первый запуск приложения, введите данные будущего Администратора:");
            admin = new Admin();
            admin.setWithUserEmail(users);
            admin.setWithUserPassword();
            System.out.println(admin.getEmail());
            users.add(new User(admin.getEmail(),admin.getPassword()));

        } else { // данные администратора всегда записываются первой строкой в файле сохранения
            admin = new Admin();
            admin.setEmail(users.get(0).getEmail());
            admin.setPassword(users.get(0).getPassword());
            initializationUser();
        }

        userMenu();
        saveLibraryToFile();
        saveUsers();
        System.out.println("До свидания!");
    }

    private void loadLibraryFromFile() throws IOException {
        library = new ArrayList<>();
        System.out.println("Введите директорию файла со списком книг:");
        BufferedReader readerBooks = new BufferedReader(new InputStreamReader(System.in));
        String filePath = readerBooks.readLine();

        if (filePath.equals("")) {
            System.out.println("Пустая строка!");
            loadLibraryFromFile();
        } else {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(new File(filePath)));
                String line = reader.readLine();

                while (line != null) {
                    library.add(createBook(line));
                    line = reader.readLine();
                }
            } catch (FileNotFoundException e) {
                System.out.println("Указанный файл не найден!");
                loadLibraryFromFile();
            }
        }
        readerBooks.close();
    }

    private void loadUsersFromFile() throws IOException {
        users = new ArrayList<>();
        System.out.println("Введите директорию файла со списком пользователей:");
        BufferedReader readerBooks = new BufferedReader(new InputStreamReader(System.in));
        String filePath = readerBooks.readLine();
        readerBooks.close();

        if (filePath.equals("")) {
            System.out.println("Пустая строка!");
            loadUsersFromFile();
        } else {
            try {
                FileReader fileReader = new FileReader(new File(filePath));
                BufferedReader reader = new BufferedReader(fileReader);
                String line = reader.readLine();

                while (line != null) {
                    users.add(createUser(line));
                    line = reader.readLine();
                }
                reader.close();
            } catch (FileNotFoundException e) {
                System.out.println("Указанный файл не найден!");
                loadUsersFromFile();
            }
        }
        fileReader.close();
        reader.close();
    }

    private Book createBook(String string) {
        String[] book = splitTextToSentence(string);
        return new Book(book[0], book[1], Integer.parseInt(book[2]), book[3].equals("true"), book[4]);
    }

    private User createUser(String string) {
        String[] user = splitTextToSentence(string);
        return new User(user[0], new CaesarCipher().decrypt(user[1]));
    }

    private String[] splitTextToSentence(String string) {
        Pattern pattern = Pattern.compile("[|]");
        return pattern.split(string,0);
    }

    private void saveLibraryToFile() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите директорию файла для сохранения списка книг:");
        String filePath = reader.readLine();
        reader.close();

        if (filePath.equals("")) {
            System.out.println("Пустая строка!");
            saveLibraryToFile();
        } else {
            writeUsingBufferedWriter(filePath);

            for (Book current: library) {
                String appendBook = current.getAuthor() + "|" + current.getTitle() + "|" +
                        current.getCountPages() + "|" +current.isPaper() + "|" + current.getDirectory();

                appendUsingBufferedWriter(filePath, appendBook);
            }
        }
    }

    private void saveUsers() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите директорию файла для сохранения списка пользователей:");
        String filePath = reader.readLine();
        reader.close();

        if (filePath.equals("")) {
            System.out.println("Пустая строка!");
            saveUsers();
        } else {
            writeUsingBufferedWriter(filePath);

            for (User current : users) {
                String appendUser = current.getEmail() + "|" + new CaesarCipher().encrypt(current.getPassword());
                appendUsingBufferedWriter(filePath, appendUser);
            }
        }
    }

    private void writeUsingBufferedWriter(String filePath) {
        BufferedWriter br = null;

        try {
            br = new BufferedWriter(new FileWriter(new File(filePath)));
            br.write("");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert br != null;
                br.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void appendUsingBufferedWriter(String filePath, String text) {
        BufferedWriter br = null;

        try {
            br = new BufferedWriter(new FileWriter(new File(filePath), true));
            br.write(text);
            br.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert br != null;
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void initializationUser() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("У вас уже есть учётная запись?(Да/Нет)");
        String temp = reader.readLine();

        if (temp.equals("")) {
            System.out.println("Введена пустая строка!");
            initializationUser();

        } else if (temp.equals("Да")) {
            System.out.println("Введите ваш email:");
            String email = reader.readLine();

            if (checkEmail(email)) {
                System.out.println("Введите пароль:");
                String password = reader.readLine();

                if (checkPassword(email, password)) {
                    System.out.println(email + " Добро пожаловать в библиотеку!");
                    currentUser = new User(email, password);
                } else {
                    System.out.println("Неправильный пароль!");
                    initializationUser();
                }
            } else {
                System.out.println("Этот email не зарегистрирован.");
                initializationUser();
            }

        } else if (temp.equals("Нет")) {
            System.out.println("Введите ваше имя:");
            String name = reader.readLine();

            if (name.equals("")) {
                System.out.println("Пустая строка!");
                initializationUser();
            } else {
                User current = new User(name, users);
                users.add(current);
                currentUser = current;
            }
        } else {
            initializationUser();
        }
        reader.close();
    }

    private boolean checkEmail(String email) {
        for (User current : users) {
            if (current.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkPassword(String email, String password) {
        for (User current :  users) {
            if (current.getEmail().equals(email) && current.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    private void adminMenu() throws Exception {
        int value = 0;

        System.out.println("\nДля добавления книги введите 1\n" +
                "Для удаления книги введите 2 и книгу для удаления\n" +
                "Для перехода в пользовательский режим введите 3\n");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String temp = reader.readLine();
        reader.close();

        if (temp.equals("")) {
            System.out.println("Введена пустая строка!");
            adminMenu();
        } else {
            Pattern patternCost = Pattern.compile("[1-5]");
            Matcher matcher = patternCost.matcher(temp);

            if (matcher.find()) {
                value = Integer.parseInt(temp);
            } else {
                System.out.println("Введены недопустимые символы!");
                adminMenu();
            }
        }

        if (value == 1) {
            library = admin.addBook(library, users, admin);
            adminMenu();

        } else if (value == 2) {
            library = admin.removeBook(library, new Book());
            adminMenu();

        } else if (value == 3) {
            userMenu();

        } else {
            adminMenu();
        }
    }

    private void userMenu() throws Exception {
        int value = 0;

        System.out.println("\nДля просмотра списка книг введите 1 (Для просмотра следующих страниц нажимайте Enter)\n" +
                "Для поиска книги по автору, введите 2\n" +
                "Для поиска книги по названию, введите 3\n" +
                "Для поиска конкретной книги, введите 4 и укажите книгу\n" +
                "Для предложения книги в библиотеку, введите 5\n" +
                "Для смены пароля введите 6\n" +
                "Для выхода введите 7\n" +
                "Для перехода в режим Администратора, введите 8\n");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String temp = reader.readLine();

        if (temp.equals("")) {
            System.out.println("Введена пустая строка!");
            userMenu();

        } else {
            Pattern patternCost = Pattern.compile("[1-8]");
            Matcher matcher = patternCost.matcher(temp);

            if (matcher.find()) {
                value = Integer.parseInt(temp);
            } else {
                System.out.println("Введены недопустимые символы!");
                userMenu();
            }
        }

        if (value == 1) {
            currentUser.browseLibrary(library);
            userMenu();

        } else if (value == 2) {
            currentUser.searchBookWithAuthor(library);
            userMenu();

        } else if (value == 3) {
            currentUser.searchBookWithTitle(library);
            userMenu();

        } else if (value == 4) {
            currentUser.searchBookWithAuthorAndTitle(library);
            userMenu();

        } else if (value == 5) {
            currentUser.userOfferBook(admin, currentUser);
            userMenu();

        } else if (value == 6) {

            for (User current : users) {
                if (current.getEmail().equals(currentUser.getEmail())) {
                    currentUser.setWithUserPassword();
                    current.setPassword(currentUser.getPassword());
                }
            }
            userMenu();

        } else if (value == 7) {
            System.out.println("Не забудьте корректно указать директории файлов сохранения данных.");

        } else if (value == 8) {
            System.out.println("Введите пароль:");
            temp = reader.readLine();

            if (temp.equals(admin.getPassword())) {
                adminMenu( );

            } else {
                System.out.println("Пароль неверный!");
                userMenu();
            }
        }
        reader.close();
    }
}
