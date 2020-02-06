package tasks.homelibrary.resource;

public class CaesarCipher {

    public String encrypt(String password) {
        String encryptPassword = "";

        for (char c : password.toCharArray()) {
            if (c != ' ') {
                encryptPassword = encryptPassword.concat(Character.toString((char) (c + 3)));
            }
        }
        return encryptPassword;
    }

    public String decrypt(String encryptPassword) {
        String decryptPassword = "";

        for (char c : encryptPassword.toCharArray()) {
            if (c != ' ') {
                decryptPassword = decryptPassword.concat(Character.toString((char) (c - 3)));
            }
        }
        return decryptPassword;
    }
}
