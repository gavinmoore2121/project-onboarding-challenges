package sep.thirteen;

public class DecimalToOctal {

    public static void main(String[] args) {
        System.out.println(decimalToOctal(5));
        System.out.println(decimalToOctal(9));
        System.out.println(decimalToOctal(25));
        System.out.println(decimalToOctal(7562));
    }

    /**
     * Convert a decimal long to it's octal equivalent using the divide-by-8 method.
     *
     * @param num The decimal number to convert.
     * @return The given number in octal form, stored as a long.
     */
    public static long decimalToOctal(long num) {
        long octalNum = 0;
        int digit = 0; // Counter to maintain what digit is next.

        // Loop through array, setting each digit to modulus 8 of the current number.
        while (num > 0) {
            octalNum += (long) Math.pow(10, digit) * (num % 8);
            num = num / 8;
            digit += 1;
        }
        return octalNum;
    }
}
