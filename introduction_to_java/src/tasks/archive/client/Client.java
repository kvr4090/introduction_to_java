package tasks.archive.client;

import tasks.archive.server.FileStudent;

import java.io.*;
import java.net.ConnectException;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Client {
    private FileStudent fileStudent;
    
    private void run() throws IOException {
        try {
            menu();
        } catch (ConnectException e) {
            System.out.println("сервер не работает!");
        }
    }

    private void menu () throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nДля запроса дела, введите 1.\n" +
                "Для добавления нового дела, введите 2.\n" +
                "Для выхода, введите 3.\n" +
                "Для остановки сервера, введите 4.\n");
        String number = reader.readLine();

        Pattern pattern = Pattern.compile("[1-4]");
        Matcher matcher = pattern.matcher(number);

        if (matcher.find()) {
            int temp = Integer.parseInt(number);

            if (temp == 1) {
                requestFileStudent();

                if (clientWork(fileStudent.getNumberOwner()).equals("empty")) {
                    System.out.println("такого дела нет!");

                } else {
                    createFileStudent(clientWork(fileStudent.getNumberOwner()));
                    System.out.println("Для просмотра дела, введите 1.\n" +
                            "Для редактирования дела, введите 2.\n");
                    String choice = reader.readLine();

                    Pattern pattern1 = Pattern.compile("[1-2]");
                    Matcher matcher1 = pattern1.matcher(choice);

                    if (matcher1.find()) {
                        int asd = Integer.parseInt(choice);

                        if (asd == 1) {
                            toScreenFileStudent();
                        } else {
                            editFileStudentText();
                            System.out.println(clientWork(fileStudent.getNumberOwner() + "|" + fileStudent.getText()));
                        }
                    } else {
                        System.out.println("Введите данные соответствующие требованиям!");
                    }
                }
                menu();
            } else if (temp == 2) {
                System.out.println("Для добавления дела, введите пароль (11 символов):");
                String pass = reader.readLine();
                Pattern pattern2 = Pattern.compile("[0-9]{11}");
                Matcher matcher2 = pattern2.matcher(pass);

                if (matcher2.find()) {
                    if (clientWork(pass).equals("true")) {
                        addFileStudent();
                        System.out.println(clientWork(fileStudent.getNumberOwner() + "|" + fileStudent.getText()));

                    } else {
                        System.out.println("Неверный пароль!");
                    }
                } else {
                    System.out.println("Введите пароль соответствующий требованиям!");
                }
                menu();
            } else if (temp == 3) {
                System.out.println("До свидания!");
            } else if (temp == 4) {
                stopServer();
            }
        } else {
            System.out.println("Ввели какую то дичь!");
            menu();
        }
        reader.close();
    }

    private void stopServer() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Для остановки сервера, введите пароль (11 символов):");
        String pass = reader.readLine();
        Pattern pattern = Pattern.compile("[0-9]{11}");
        Matcher matcher = pattern.matcher(pass);

        if (matcher.find()) {
            if (clientWork(pass).equals("true")) {
                System.out.println(clientWork("stop"));

            } else {
                System.out.println("Неверный пароль!");
                menu();
            }
        } else {
            System.out.println("Неверный пароль!");
            menu();
        }
        reader.close();
    }

    private void requestFileStudent() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        fileStudent = new FileStudent();
        System.out.println("Для запроса дела студента введите номер студента:");
        String number = reader.readLine();
        Pattern pattern = Pattern.compile("[0-9]{1,10}");
        Matcher matcher = pattern.matcher(number);

        if (matcher.find()) {
            fileStudent.setNumberOwner(number);
        } else {
            System.out.println("Введите данные соответствующие требованиям!");
            requestFileStudent();
        }
        reader.close();
    }

    private void createFileStudent(String string) {
        String[] list = splitStringToParts(string);
        fileStudent = new FileStudent(list[0], list[1]);
    }

    private String[] splitStringToParts(String string) {
        Pattern pattern = Pattern.compile("[|]");
        return pattern.split(string,0);
    }

    private void toScreenFileStudent() {
        System.out.println(fileStudent.toString());
    }

    private void editFileStudentText() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Вводите требуемую информацию:");
        String text = reader.readLine();
        fileStudent.setText(text);
        reader.close();
    }

    private void addFileStudent() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Вводите номер студента");
        String number = reader.readLine();
        Pattern pattern = Pattern.compile("[0-9]{1,10}");
        Matcher matcher = pattern.matcher(number);

        if (matcher.find()) {
            System.out.println("Вводите требуемую информацию о студенте:");
            String test = reader.readLine();
            fileStudent = new FileStudent(number, test);
        } else {
            System.out.println("Введите данные соответствующие требованиям!");
            addFileStudent();
        }
        reader.close();
    }

    private String clientWork(String toServer) throws IOException {
        String host = "localhost";
        int port = 3333;
        Socket clientSocket = new Socket(host, port);
        DataInputStream din = new DataInputStream(clientSocket.getInputStream());
        DataOutputStream dOut = new DataOutputStream(clientSocket.getOutputStream());

        String serverAnswer;
        dOut.writeUTF(toServer);
        dOut.flush();
        serverAnswer = din.readUTF();
        dOut.close();
        clientSocket.close();
        return serverAnswer;
    }
}
