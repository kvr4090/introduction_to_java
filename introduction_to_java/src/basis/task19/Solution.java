package basis.task19;

/* Даны два числа. Определить цифры, входящие в запись как первого так и второго числа. */

import java.util.HashSet;

public class Solution {
    private String toStringNumber1;
    private String toStringNumber2;
    private HashSet<Integer> repeatedNumbers;

    public Solution(Double num1, Double num2) {
        toStringNumber1 = num1.toString();
        toStringNumber2 = num2.toString();
    }

    private String maxLength() {
        if (toStringNumber1.length() > toStringNumber2.length()) {
            return toStringNumber1;
        } else {
            return toStringNumber2;
        }
    }

    private String minLength() {
        if (toStringNumber1.length() < toStringNumber2.length()) {
            return toStringNumber1;
        } else {
            return toStringNumber2;
        }
    }

    private void findRepeatedNumbers() {
        for (int i = 0; i < Math.min(toStringNumber1.length(), toStringNumber2.length()); i++) {
            for (int j = 0; j < Math.max(toStringNumber1.length(), toStringNumber2.length()); j++) {
                if ((toStringNumber1.charAt(i) != '.') && (toStringNumber2.charAt(i) != '.') && (minLength().charAt(i) == maxLength().charAt(j))) {

                    repeatedNumbers.add(Integer.parseInt(Character.toString(maxLength().charAt(j))));
                }
            }
        }
    }

    public HashSet<Integer> returnResult() {
        repeatedNumbers = new HashSet<>();
        findRepeatedNumbers();
        return repeatedNumbers;
    }

}
