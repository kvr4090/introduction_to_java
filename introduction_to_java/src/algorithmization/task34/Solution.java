package algorithmization.task34;

import java.util.Arrays;

/*
 * Даны дроби, ............. p, q - натуральные. Составить программу, которая приводит эти дроби к общему
 * знаменателю и упорядочивает их в порядке возрастания.
 */

public class Solution {

    public int[] fractionNOZ(int[] p, int[] q) {
        int temp = 1;
        int[] resultFraction = new int[p.length];

        for (int value : q) {
            temp *= value;
        }

        for (int i = 0; i < p.length; i++) {
            resultFraction[i] = (temp * p[i]) / (q[i]);
            q[i] = temp;
        }
        Arrays.sort(resultFraction);
        return resultFraction;
    }
}