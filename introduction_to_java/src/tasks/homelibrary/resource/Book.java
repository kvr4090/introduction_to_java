package tasks.homelibrary.resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Book {
    private String author;
    private String title;
    private int countPages;
    private boolean isPaper;
    private String directory;

    public Book() throws IOException {
        setAuthor();
        setTitle();
        setCountPages();
        setPaper();
        setDirectory();
    }

    public Book(String crutch) throws IOException {
        setAuthor();
        setTitle();
    }

    public Book(String author, String title, int countPages, boolean isPaper, String directory) {
        this.author = author;
        this.title = title;
        this.countPages = countPages;
        this.isPaper = isPaper;
        this.directory = directory;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getCountPages() {
        return countPages;
    }

    public String getDirectory() {
        return directory;
    }

    public boolean isPaper() {
        return isPaper;
    }

    private String isBookPaper() {
        if (isPaper) {
            return "Книга в бумажном варианте, находится в(на)" + directory;
        } else {
            return "Книга в электронном варианте, находится в(на)" + directory ;
        }
    }

    private void setAuthor() throws IOException {
        System.out.println("Введите автора книги:");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String temp = reader.readLine();

            if (temp.equals("")) {
                System.out.println("Пустая строка!");
                setAuthor();
            } else {
                Pattern pattern = Pattern.compile("[A-zА-я\\s]");
                Matcher matcher = pattern.matcher(temp);

                if (matcher.find()) {
                    author = temp;
                } else {
                    System.out.println("Неправльное имя!");
                    setAuthor();
                }
            }
        }
    }

    private void setTitle() throws IOException {
        System.out.println("Введите название книги:");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String temp = reader.readLine();

            if (temp.equals("")) {
                System.out.println("Пустая строка!");
                setTitle();
            } else {
                Pattern pattern = Pattern.compile("[А-яA-z0-9\\s.,!:]");
                Matcher matcher = pattern.matcher(temp);

                if (matcher.find()) {
                    title = temp;
                } else {
                    System.out.println("Неправильное название!");
                    setTitle();
                }
            }
        }
    }

    private void setCountPages() throws IOException {
        System.out.println("Введите количество страниц в книге:");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String temp = reader.readLine();

            if (temp.equals("")) {
                System.out.println("Пустая строка!");
                setCountPages();
            } else {
                Pattern pattern = Pattern.compile("[^0-9]");
                Matcher matcher = pattern.matcher(temp);

                if (!matcher.find()) {
                    int i = Integer.parseInt(temp);

                    if (i > 0) {
                        countPages = i;
                    }
                } else {
                    System.out.println("Неправильное число!");
                    setCountPages();
                }
            }
        }
    }

    private void setPaper() throws IOException {
        System.out.println("Введите формат книги (бумажная/электронная)");
        
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String temp = reader.readLine();

            if (temp.equals("")) {
                System.out.println("Пустая строка!");
                setPaper();
            } else {
                if (temp.equals("электронная")) {
                    isPaper = false;

                } else if (temp.equals("бумажная")) {
                    isPaper = true;

                } else {
                    System.out.println("Неправильный формат!");
                    setPaper();
                }
            }   
        }
    }

    private void setDirectory() throws IOException {
        System.out.println("Укажите директорию/место хранения книги:");
        
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String temp = reader.readLine();

            if (temp.equals("")) {
                System.out.println("Пустая строка!");
                setDirectory();
            } else {
                directory = temp;
            }   
        }
    }

    @Override
    public String toString() {
        return "Автор " + author + ", Название книги : " + title + ", количество страниц - " + countPages + ", " + isBookPaper();
    }
}
