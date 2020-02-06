package algorithmization.task10;

/*
 * Дан целочисленный массив с количеством элементов п. Сжать массив, выбросив из него каждый второй
 * элемент (освободившиеся элементы заполнить нулями). Примечание. Дополнительный массив не использовать.
 */

public class Solution {

    public void compressArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if(i % 2 != 0) {
                array[i] = 0;
            }
        }
    }
}
