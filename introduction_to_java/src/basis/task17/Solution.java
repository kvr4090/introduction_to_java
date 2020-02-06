package basis.task17;

/* Вывести на экран соответствий между символами и их численными обозначениями в памяти компьютера. */

public class Solution {

    public void showASCII() {
        char charSign  = '\u0000';
        int charNumber = 0;

        System.out.println("ASCII символы и коды:");

        for (int i = 0; i < 256; i++) {
            charSign++;
            charNumber++;
            System.out.println("sign: " + charSign + "  number: " + charNumber);
        }
    }
}
