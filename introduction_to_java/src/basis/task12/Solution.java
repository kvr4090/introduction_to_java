package basis.task12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Напишите программу, где пользователь вводит любое целое положительное число.
 * А программа суммирует все числа от 1 до введенного пользователем числа (не включительно)
 */

public class Solution {
    private int result;

    public int returnSum() throws IOException {
        calculateSum();
        return result;
    }

    private void calculateSum() throws IOException {
        System.out.println("Введите любое целое положительное число.");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int a = Integer.parseInt(reader.readLine());

            if (a < 1) {
                System.out.println("Введено число не соответствующее условию.");
                calculateSum();
            } else {
                result = 0;

                for (int i = 1; i < a; i++) {
                    result += i;
                }
            }
        }
    }
}
