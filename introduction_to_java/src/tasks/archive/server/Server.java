package tasks.archive.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Server {
    private String archivePath;
    private FileStudent fileStudent;
    private String password;
    
    public void run() throws IOException {
        setArchivePath();
        setPassword();
        serverWork();
    }

    private void setArchivePath() throws IOException {
        System.out.println("Введите директорию в которой находятся дела студентов:");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String filePath = reader.readLine();

            if (filePath.equals("")) {
                System.out.println("Пустая строка!");
                setArchivePath();
            } else {
                archivePath = filePath;
            }
        } 
    }

    private void setPassword() throws IOException {
        System.out.println("Установите числовой пароль из 11 знаков:");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String pass = reader.readLine();
            Pattern pattern = Pattern.compile("[0-9]{11}");
            Matcher matcher = pattern.matcher(pass);

            if (matcher.find()) {
                password = pass;
            } else {
                System.out.println("Введите пароль соответствующий требованиям!");
                setPassword();
            }
        }
    }

    private void loadFileStudentFromFile(String studentNumber) throws IOException {
        String filePath = archivePath + studentNumber +".xml";

        try (FileReader fileRdr = new FileReader(new File(filePath));
             BufferedReader fileReader = new BufferedReader(fileRdr)) {
            
            String line = fileReader.readLine();

            while (line != null) {
                createFileStudentFromFile(line);
                line = fileReader.readLine();
            }
        }
    }

    private void saveFileStudentToArchive() {
        String filePath = archivePath + fileStudent.getNumberOwner() + ".xml";
        writeUsingBufferedWriter(filePath);
        appendUsingBufferedWriter(filePath, createStringFileStudent());
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

    private void createFileStudentFromFile(String string) {
        String[] list = splitStringToParts(string);
        fileStudent = new FileStudent(list[0], list[1]);
    }

    private String[] splitStringToParts(String string) {
        Pattern pattern = Pattern.compile("[|]");
        return pattern.split(string,0);
    }

    private String createStringFileStudent() {
        return fileStudent.getNumberOwner() + "|" + fileStudent.getText();
    }

    private boolean isInTheArchives(String numberStudent) {
        File folder = new File(archivePath);
        String[] files = folder.list((folder1, name) -> name.startsWith(numberStudent + "."));

        assert files != null;
        for ( String ignored : files ) {
            return true;
        }
        return false;
    }

    private void serverWork() throws IOException {
        int port = 3333;
        ServerSocket serverSocket = new ServerSocket(port);
        Socket clientSocket = serverSocket.accept();
        DataInputStream din = new DataInputStream(clientSocket.getInputStream());
        DataOutputStream dOut = new DataOutputStream(clientSocket.getOutputStream());
        String toClient;
        String fromClient = din.readUTF();

        if (fromClient.equals("stop")) {
            toClient = "Сервер заканчивает работу.";
            System.out.println(toClient);
            dOut.writeUTF(toClient);
            dOut.flush();
            din.close();
            clientSocket.close();
            serverSocket.close();

        } else {
            if (fromClient.length() < 11) {
                if (isInTheArchives(fromClient)) {
                    loadFileStudentFromFile(fromClient);
                    toClient = createStringFileStudent();
                } else {
                    toClient = "empty";
                }
            } else if (fromClient.length() > 11) {
                createFileStudentFromFile(fromClient);
                saveFileStudentToArchive();
                toClient = "Ваше дело сохранено!";
            } else {
                toClient = fromClient.equals(password) + "";
            }

            dOut.writeUTF(toClient);
            dOut.flush();
            din.close();
            clientSocket.close();
            serverSocket.close();
            serverWork();
        }
    }
}
