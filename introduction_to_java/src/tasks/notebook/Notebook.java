package tasks.notebook;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Задание 2. Блокнот. Разработать консольное приложение, работающее с Заметками
 * в Блокноте. Каждая Заметка это: Заметка (тема, дата создания, e-mail, сообщение).
 * Общие пояснения к практическому заданию.
    • В начале работы приложения данные должны считываться из файла, в конце работы – сохраняться в файл.
    • У пользователя должна быть возможность найти запись по любому параметру
        или по группе параметров (группу параметров можно определить
        самостоятельно), получить требуемые записи в отсортированном виде, найти
        записи, текстовое поле которой содержит определенное слово, а также добавить новую запись.
 * Особое условие: поиск, сравнение и валидацию вводимой информации осуществлять с использованием регулярных выражений.
 * Особое условие: проверку введенной информации на валидность должен осуществлять код, непосредственно добавляющий информацию.
 */

public class Notebook {
    private ArrayList<Note> notes;
    private ArrayList<Note> sortedNotes;

    public void run() throws IOException {
        loadNotebookFromFile();
        System.out.println("Добро пожаловать в блокнот!");
        menu();
        saveNotebookToFile();
    }

    private void menu() throws IOException {
        sortedNotes = new ArrayList<>();
        String choice;
        System.out.println("\nДля поиска заметок по параметру, введите 1\n" +
                "Для поиска записи, текстовое поле которой содержит заданное слово, введите 2\n" +
                "Для добавления заметки, введите 3\n" +
                "Для выхода введите 4.\n");
        
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            choice = reader.readLine();
        }

        Pattern pattern = Pattern.compile("^([1-4])$");
        Matcher matcher = pattern.matcher(choice);

        if (matcher.find()) {
            int value = Integer.parseInt(choice);

            if (value == 1) {
                searchNoteByParameter();
                menu();
            }

            if (value == 2) {
                for (Note current : notes) {
                    if (searchTextInNote(current.getMessage())) {
                        sortedNotes.add(current);
                    }
                }
                totalSort();
                toScreenNotes();
                clearSortedNotes();
                menu();
            }

            if (value == 3) {
                addNote();
                menu();
            }

            if (value == 4) {
                System.out.println("Корректно вводите директории файлов сохранения!");
            }

        } else {
            System.out.println("Некорректный ввод!");
            menu();
        }
    }

    private void loadNotebookFromFile() throws IOException {
        notes = new ArrayList<>();
        System.out.println("Введите директорию файла с заметками:");

        try (BufferedReader readerBooks = new BufferedReader(new InputStreamReader(System.in))) {
            String filePath = readerBooks.readLine();

            if (filePath.equals("")) {
                System.out.println("Пустая строка!");
                loadNotebookFromFile();
            } else {
                try (FileReader fileReader = new FileReader(new File(filePath));
                     BufferedReader reader = new BufferedReader(fileReader)) {

                    String line = reader.readLine();

                    while (line != null) {
                        notes.add(createNote(line));
                        line = reader.readLine();
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("Указанный файл не найден!");
                    loadNotebookFromFile();
                }
            }
        }
    }

    private Note createNote(String string) {
        String[] book = splitStringToSentence(string);
        return new Note(book[0], book[1], book[2], createDate(Integer.parseInt(book[3]), Integer.parseInt(book[4]),
                Integer.parseInt(book[5]), Integer.parseInt(book[6]), Integer.parseInt(book[7]), Integer.parseInt(book[8])));
    }

    private String[] splitStringToSentence(String string) {
        Pattern pattern = Pattern.compile("[|]");
        return pattern.split(string,0);
    }

    private Calendar createDate(int year, int month, int day, int hour, int minute, int second) {
        Calendar date = new GregorianCalendar();
        date.set(Calendar.YEAR, year);
        date.set(Calendar.MONTH, month);
        date.set(Calendar.DAY_OF_MONTH, day);
        date.set(Calendar.HOUR_OF_DAY, hour);
        date.set(Calendar.MINUTE, minute);
        date.set(Calendar.SECOND, second);
        return date;
    }

    private void saveNotebookToFile() throws IOException {
        System.out.println("Введите директорию файла для сохранения заметок:");
        
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String filePath = reader.readLine();

            if (filePath.equals("")) {
                System.out.println("Пустая строка!");
                saveNotebookToFile();
            } else {
                writeUsingBufferedWriter(filePath);

                for (Note current : notes) {
                    String appendNote = current.getTopic() + "|" + current.getMessage() + "|" + current.getEmail() +
                            "|" + current.getCalendar().get(Calendar.YEAR) + "|" + current.getCalendar().get(Calendar.MONTH) +
                            "|" + current.getCalendar().get(Calendar.DAY_OF_MONTH) + "|" + current.getCalendar().get(Calendar.HOUR_OF_DAY) +
                            "|" + current.getCalendar().get(Calendar.MINUTE) + "|" +current.getCalendar().get(Calendar.SECOND);

                    appendUsingBufferedWriter(filePath, appendNote);
                }
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

    private void appendUsingBufferedWriter(String filePath, String text) {
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

    private void addNote() throws IOException {
        notes.add(new Note());
        System.out.println("Заметка добавлена!");
    }

    private void searchNoteByParameter() throws IOException {
        String choice;
        System.out.println("\nВыбор параметров:\n" +
                "Для поиска по теме, введите 1\n" +
                "Для поиска по email, введите 2\n" +
                "Для поиска по дате, введите 3\n" +
                "При выборе нескольких параметров, цифры вводите без пробелов и знаков препинания\n" +
                "(1 или 2 или 3 или 123 или 12 или 13 или 23)\n");
        
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            choice = reader.readLine();
        }

        Pattern pattern = Pattern.compile("[0-9]");
        Matcher matcher = pattern.matcher(choice);

        if (matcher.find()) {
            int value = Integer.parseInt(choice);
            Note note = new Note("crutch");

            if (value == 1) {
                note.setTopic();

                for (Note current : notes) {
                    if (searchNoteByTopic(current, note.getTopic())) {
                        sortedNotes.add(current);
                    }
                }

                if (sortedNotes.size() == 0) {
                    System.out.println("Заметка не найдена!");
                }
                totalSort();
                toScreenNotes();
                clearSortedNotes();

            } else if (value == 2) {
                note.setEmail();

                for (Note current : notes) {
                    if (searchNoteByEmail(current, note.getEmail())) {
                        sortedNotes.add(current);
                    }
                }

                if (sortedNotes.size() == 0) {
                    System.out.println("Заметка не найдена!");
                }
                totalSort();
                toScreenNotes();
                clearSortedNotes();

            } else if (value == 3) {
                for (Note current : notes) {
                    if (searchNoteByDate(current)) {
                        sortedNotes.add(current);
                    }
                }

                if (sortedNotes.size() == 0) {
                    System.out.println("Заметка не найдена!");
                }
                totalSort();
                toScreenNotes();
                clearSortedNotes();

            } else if (value == 12) {
                note.setTopic();
                note.setEmail();

                for (Note current : notes) {
                    if (searchNoteByTopic(current, note.getTopic()) && searchNoteByEmail(current, note.getEmail())) {
                        sortedNotes.add(current);
                    }
                }

                if (sortedNotes.size() == 0) {
                    System.out.println("Заметка не найдена!");
                }
                totalSort();
                toScreenNotes();
                clearSortedNotes();

            } else if (value == 13) {
                note.setTopic();

                for (Note current : notes) {
                    if (searchNoteByTopic(current, note.getTopic()) && searchNoteByDate(current)) {
                        sortedNotes.add(current);
                    }
                }

                if (sortedNotes.size() == 0) {
                    System.out.println("Заметка не найдена!");
                }

                totalSort();
                toScreenNotes();
                clearSortedNotes();

            } else if (value == 23) {
                note.setEmail();

                for (Note current : notes) {
                    if (searchNoteByEmail(current, note.getEmail()) && searchNoteByDate(current)) {
                        sortedNotes.add(current);
                    }
                }

                if (sortedNotes.size() == 0) {
                    System.out.println("Заметка не найдена!");
                }
                totalSort();
                toScreenNotes();
                clearSortedNotes();

            } else if (value == 123) {
                note.setTopic();
                note.setEmail();

                for (Note current : notes) {
                    if (searchNoteByTopic(current, note.getTopic()) && searchNoteByEmail(current, note.getEmail()) && searchNoteByDate(current)) {
                        sortedNotes.add(current);
                    }
                }

                if (sortedNotes.size() == 0) {
                    System.out.println("Заметка не найдена!");
                }
                totalSort();
                toScreenNotes();
                clearSortedNotes();

            } else {
                System.out.println("Введено неверное значение!");
                searchNoteByParameter();
            }
        } else {
            System.out.println("Введено неверное значение!");
            searchNoteByParameter();
        }
    }

    private boolean searchNoteByTopic(Note note, String topic) {
        String text = note.getTopic();
        Pattern pattern = Pattern.compile(topic);
        Matcher matcher = pattern.matcher(text);

        return matcher.lookingAt();
    }

    private boolean searchNoteByEmail(Note note, String email) {
        Pattern pattern = Pattern.compile(email);
        String text1 = note.getEmail();
        Matcher matcher1 = pattern.matcher(text1);

        return matcher1.lookingAt();
    }

    private boolean searchNoteByDate(Note note) throws IOException {
        Calendar calendar = setDate();

        return note.getCalendar().get(Calendar.YEAR) == calendar.get(Calendar.YEAR) &&
                note.getCalendar().get(Calendar.MONTH) == calendar.get(Calendar.MONTH) &&
                note.getCalendar().get(Calendar.DAY_OF_MONTH) == calendar.get(Calendar.DAY_OF_MONTH);
    }

    private boolean searchTextInNote(String string) throws IOException {
        String word;
        System.out.println("Введите слово для поиска:");
        
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            word = reader.readLine();
        }
       
        String [] list = splitTextToSentence(string);

        for (String current : list) {
            if (current.equals(word)) {
                return true;
            }
        }
        return false;
    }

    private String[] splitTextToSentence(String string) {
        Pattern pattern = Pattern.compile("[\\s]");
        return pattern.split(string,0);
    }

    private Calendar setDate() throws IOException {
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.YEAR, setDateYear());
        calendar.set(Calendar.MONTH, setDateMonth());
        calendar.set(Calendar.DAY_OF_MONTH, setDateDay());
        return calendar;
    }

    private int setDateYear() throws IOException {
        String year;
        System.out.println("Введите год заметки:");
        
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            year = reader.readLine();
        }
        
        Pattern pattern = Pattern.compile("[0-9]{4}");
        Matcher matcher = pattern.matcher(year);

        if (matcher.find()) {
            return Integer.parseInt(year);
        } else {
            System.out.println("Проверьте введённый год!");
            setDateYear();
        }
        return 0;
    }

    private int setDateMonth() throws IOException {
        String month;
        System.out.println("Введите месяц заметки(1-12):");
        
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            month = reader.readLine();
        }
        
        Pattern pattern = Pattern.compile("^(0?[1-9]|1[0-2])$");
        Matcher matcher = pattern.matcher(month);

        if (matcher.find()) {
            return Integer.parseInt(month)-1;
        } else {
            System.out.println("Проверьте введённый месяц!");
            setDateMonth();
        }
        return 0;
    }

    private int setDateDay() throws IOException {
        String month;
        System.out.println("Введите  число дня заметки(1-31):");
        
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            month = reader.readLine();
        }
        
        Pattern pattern = Pattern.compile("^([1-9]|[1-2][0-9]|3[0-1])$");
        Matcher matcher = pattern.matcher(month);

        if (matcher.find()) {
            return Integer.parseInt(month);
        } else {
            System.out.println("Проверьте введённый день!");
            setDateDay();
        }
        return 0;
    }

    private void clearSortedNotes() {
        sortedNotes = new ArrayList<>();
    }

    private void toScreenNotes() {
        for (Note current : sortedNotes) {
            System.out.println(current.toString());
        }
    }

    private void totalSort() {
        sortNotesByEmail();
        sortNotesByDate();
        sortNotesByTopic();
    }

    private void sortNotesByTopic() {
        Comparator<Note> comparator = Comparator.comparing(Note::getTopic);
        sortedNotes.sort(comparator);
    }

    private void sortNotesByEmail() {
        Comparator<Note> comparator = Comparator.comparing(Note::getEmail);
        sortedNotes.sort(comparator);
    }

    private void sortNotesByDate() {
        Comparator<Note> comparator = Comparator.comparing(obj -> obj.getCalendar().get(Calendar.YEAR));
        comparator = comparator.thenComparing(obj -> obj.getCalendar().get(Calendar.MONTH));
        comparator = comparator.thenComparing(obj -> obj.getCalendar().get(Calendar.DAY_OF_MONTH));
        sortedNotes.sort(comparator);
    }
}
