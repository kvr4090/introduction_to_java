package strings.task1;

/* Дан массив названий переменных в camelCase. Преобразовать названия в snake_case. */

public class Solution {

    public void convertArray(String[] array){
        for (int i = 0; i < array.length; i++) {
            array[i] = camelToSnake(array[i]);
        }
    }

    private String camelToSnake(String word) {
        String b = "";

        for (int i = 0; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                b = word.replaceFirst(Character.toString(word.charAt(i)), "_".concat(Character.toString(Character.toLowerCase(word.charAt(i)))));
            }
        }
        return b;
    }
}
