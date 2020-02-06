package algorithmization.task28;

import java.util.Arrays;

/*
 * Даны две последовательности
 * a1<=a2<=...an и b1<=b2<=...bm. Образовать из них новую последовательность
 * чисел так, чтобы она тоже была неубывающей. Примечание. Дополнительный массив не использовать.
 */

public class Solution {

    public int[] uniteSequence(int[] sequenceFirst, int[] sequenceSecond) {
        int[] result = new int[sequenceFirst.length + sequenceSecond.length];

        System.arraycopy(sequenceFirst,0, result, 0, sequenceFirst.length );
        System.arraycopy(sequenceSecond,0, result, sequenceFirst.length, sequenceSecond.length );
        Arrays.sort(result);

        return result;
    }
}