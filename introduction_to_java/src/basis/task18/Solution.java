package basis.task18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Для каждого натурального числа в промежутке от m до n вывести все делители, кроме единицы и самого числа.
 * m и n вводятся с клавиатуры.
 */

public class Solution {

    public void showDivisor() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(reader.readLine());
        int n = Integer.parseInt(reader.readLine());

        while (m <= n) {
            System.out.println("число " + m + " делители: ");

            for (int i = 2; i <= m - 1; i++) {
                if (m % i == 0) {
                    System.out.print(i + ",");
                }
            }

            m = m + 1;
        }
    }
}