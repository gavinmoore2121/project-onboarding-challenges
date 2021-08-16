import java.util.ArrayList;
import java.util.Arrays;

public class WordBucket {

    /**
     * Main class for testing and demonstration purposes. Calls the "bucketize" function and prints output for several
     * sample inputs.
     */
    public static void main(String[] args) {
        WordBucket testBucket = new WordBucket();
        System.out.println(Arrays.toString(testBucket.bucketize("she sells sea shells by the sea", 10)));
        System.out.println(Arrays.toString(testBucket.bucketize("these words are too long", 2)));
        System.out.println(Arrays.toString(testBucket.bucketize("the mouse jumped over the cheese", 7)));
        System.out.println(Arrays.toString(testBucket.bucketize("fairy dust coated the air", 20)));
        System.out.println(Arrays.toString(testBucket.bucketize("a b c d e", 2)));
    }


    /**
     * Divides a string into "word buckets" where each bucket contains bucketSize or fewer characters. Spaces count as
     * one character, unless they occur at the beginning or end of a bucket in which case they are trimmed. If a word
     * is longer than the max bucket size, an empty string is returned.
     *
     * @param input: The phrase to separate into buckets.
     * @param bucketSize: The maximum size of the buckets.
     * @return An array of strings, where each index contains a single "bucket," or an empty array if the string cannot
     * be divided.
     */
    private String[] bucketize(String input, int bucketSize) {
        ArrayList<String> outputList = new ArrayList<String>();
        // split into space-divided substrings
        String[] inputSplit = input.split(" ");

        // iterate through substrings, checking if the current substring can be added to the current bucket.
        int currentBucket = 0;
        outputList.add("");
        for (String word: inputSplit) {
            // Check if word can be added to previous bucket
            if (outputList.get(currentBucket).length() + 1 + word.length() <= bucketSize) {
                // A touch inefficient, but check if a word is already in this bucket to determine if a space is needed.
                if (outputList.get(currentBucket).length() > 0) {
                    outputList.set(currentBucket, outputList.get(currentBucket) + " " + word);
                }
                else outputList.set(currentBucket, word);
            }

            // Check if word size is less than bucket size. Return empty array if not.
            else if (word.length() > bucketSize) {
                return new String[]{};
            }

            // If word is can't fit in previous bucket but is less than bucket size, add it to next bucket.
            else {
                outputList.add(word);
                currentBucket++;
            }
        }

        // Convert to String array for output and return
        String[] output = new String[outputList.size()];
        output = outputList.toArray(output);
        return output;
    }
}
