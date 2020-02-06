package algorithmization.task8;

/*
 * Дана последовательность целых чисел a1,a2,....,an
 * Образовать новую последовательность, выбросив из исходной те члены, которые равны min(a1,a2,....,an)
 */

public class Solution {

    public int[] newSequence(int[] sequence) {
        int count = 0;
        int j = 0;
        int min = Integer.MAX_VALUE;
        int[] sequenceNew = new int[sequence.length - count];

        for (int value : sequence) {
            if (value < min) {
                count++;
                min = value;
            }
        }

        for (int value : sequence) {
            if (value != min) {
                sequenceNew[j] = value;
                j++;
            }
        }

        return sequenceNew;
    }
}
