package algorithmization.task33;

import java.util.ArrayList;

/*
 * Пусть даны две неубывающие последовательности действительных чисел
 * a1 a2  an и b1  b2 bm Требуется указать те места, на которые нужно вставлять элементы последовательности
 * b1 b2 bm в первую последовательность так, чтобы новая последовательность оставалась возрастающей.
 */

public class Solution {

    public ArrayList<Integer> indexToInsert(int[] a , int[] b) {
        ArrayList<Integer> index = new ArrayList<>();

        for (int value : b) {

            if (a[a.length - 1] < value) {
                index.add(a.length - 1);
                break;
            }

            for (int j = 0; j < a.length; j++) {
                if (j == a.length - 1) {
                    break;
                }

                if ((a[j] < value) && value < a[j + 1]) {
                    index.add(j);
                }
            }
        }
        return index;
    }
}