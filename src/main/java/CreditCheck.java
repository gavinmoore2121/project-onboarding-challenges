public class CreditCheck {

    /**
     * Main class for demonstration purposes. Calls the validateCard function on some sample cards and
     * outputs the result.
     */
    public static void main(String[] args) {
        CreditCheck testCreditCheck = new CreditCheck();
        // Should print false
        System.out.println(testCreditCheck.validateCard(1234567890123456L));
        // Should print true
        System.out.println(testCreditCheck.validateCard(1234567890123452L));
    }

    /**
     * Check if a credit card is a valid card number, based its length and the Luhn test.
     *
     * Confirms card is between 14 and 19 digits, and that the rightmost digit of the sum of all digits in the reversed
     * sequence where the final "check digit" is removed and each odd numbered digit is doubled is equal to 10 - the
     * check digit. For additional information on the Luhn test, see https://en.wikipedia.org/wiki/Luhn_algorithm.
     *
     * @param card The card number to validate.
     * @return True if the card passes the length and Luhn tests, otherwise false.
     */
    public boolean validateCard(long card) {
        int cardLength = String.valueOf(card).length();
        // Return false if card is an invalid length
        if (cardLength < 13 || cardLength > 19) return false;

        int digitSum = 0;
        // Iterate through digits of card, removing the final "check digit."
        for (int i=1; i < cardLength; i++) {
            // Get value of specific digit.
            int digitValue = (int) (card / (Math.pow(10, cardLength - i)) % 10);
            // If digit index would be odd in a reversed card num with the check removed, double it.
            if ((cardLength - i) % 2 == 1) {
                // If digit doubled is greater than 10, sum the digits.
                digitValue = (digitValue * 2) / 10 + (digitValue * 2) % 10;
            }
            // Add digit value to the running sum
            digitSum += digitValue;
        }
        // Check if 10 - last digit of sum is equal to the check digit and return.
        return (10 - digitSum % 10 == card % 10);
    }

}
