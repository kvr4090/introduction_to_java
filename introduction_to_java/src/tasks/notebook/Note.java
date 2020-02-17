package tasks.notebook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Note {
    private String topic;
    private String message;
    private String email;
    private Calendar calendar;

    public Note() throws IOException {
        setTopic();
        setMessage();
        setEmail();
        setCalendar();
    }

    public Note(String topic, String message, String email, Calendar calendar) {
        this.topic = topic;
        this.message = message;
        this.email = email;
        this.calendar = calendar;
    }

    public Note(String crutch) {
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic() throws IOException {
        System.out.println("Введите тему заметки:");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String topic = reader.readLine();

            Pattern pattern = Pattern.compile("[A-zА-я0-9\\s]");
            Matcher matcher = pattern.matcher(topic);

            if (matcher.find()) {
                this.topic = topic;
            } else {
                System.out.println("Некорректный ввод!");
                setTopic();
            }
        }
    }

    public String getMessage() {
        return message;
    }

    public void setMessage() throws IOException {
        System.out.println("Введите текст заметки:");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String message = reader.readLine();

            Pattern pattern = Pattern.compile(".+");
            Matcher matcher = pattern.matcher(message);

            if (matcher.find()) {
                this.message = message;
            } else {
                System.out.println("Некорректный ввод!");
                setMessage();
            }   
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail() throws IOException {
        System.out.println("Введите адрес электронной почты: ");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String email = reader.readLine();

            Pattern pattern = Pattern.compile("^[A-z0-9._%+-]+@[A-z0-9.-]+\\.[A-z]{2,6}$");
            Matcher matcher = pattern.matcher(email);

            if (matcher.find()) {
                this.email = email;
            } else {
                System.out.println("Несуществующий адрес электронной почты.");
                setEmail();
            }
        }
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar() {
        this.calendar =  new GregorianCalendar();
    }

    @Override
    public String toString() {
        return  "Тема заметки: " + '\'' + topic + '\'' +
                ", сообщение: " + '\'' + message + '\'' +
                ", email " + '\'' + email + '\'' +
                ", дата " + calendar.getTime();
    }
}
