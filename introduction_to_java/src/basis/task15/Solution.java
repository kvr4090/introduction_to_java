package basis.task15;

import java.math.BigInteger;

/* Составить программу нахождения произведения квадратов первых двухсот чисел.(1->200) */

public class Solution {

    public BigInteger calculateMultiplication() {
        BigInteger temp1 = BigInteger.ONE;
        BigInteger temp2 = BigInteger.ONE;
        BigInteger result = BigInteger.ONE;
        int counter = 1;

        while (counter < 201 ) {
            result = result.multiply(temp2.multiply(temp2));
            temp2 = temp2.add(temp1);
            counter++;
        }

        return result;
    }
}
