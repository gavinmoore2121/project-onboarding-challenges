package sep.thirteen;

public class Rot13Encryption {

    public static void main(String[] args) {
        System.out.println(encryptUsingRot13("abcdefg"));
        System.out.println(encryptUsingRot13("ABCDEFG"));
        System.out.println(encryptUsingRot13("nopqrst"));
        System.out.println(encryptUsingRot13("NOPQRST"));
        System.out.println(encryptUsingRot13("Your secret message goes here!!!"));
    }

    /**
     * Encrypt a String using the ROT13 technique. Converts all alphabetic characters to the character 13 letters
     * later. Maintains casing, and "loops" back to the start of the alphabet for characters past the 13th letter.
     *
     * @param message The message to encrypt.
     * @return The String message in ROT13 encryption.
     */
    public static String encryptUsingRot13 (String message) {
        // Convert to character array
        char[] chars = message.toCharArray();
        // Iterate through characters, add 13 to its hexadecimal number.
        for (int i = 0; i < chars.length; i++) {
            // Check if character is in alphabet
            if ((chars[i] > 96 && chars[i] < 123) || (chars[i] > 64  && chars[i] < 91)) {
                // If necessary, subtract 13 to 'loop' back to the start of the alphabet.
                if ((chars[i] > 109) || (chars[i] > 77 && chars[i] < 91)) {
                    chars[i] = (char) (chars[i] - 13);
                }
                // If not necessary, just add 13.
                else chars[i] = (char) (chars[i] + 13);
            }
        }
        // Convert back to String and return encrypted message.
        return String.valueOf(chars);
    }
}
