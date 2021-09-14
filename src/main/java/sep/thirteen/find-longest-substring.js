/**
 * Find the longest non-repeating substring in a string and return it. If there are multiple substrings of the
 * same length, the first substring of the max length is returned.
 *
 * @param {string} string The string to search.
 * @returns {string} The longest substring.
 */
function findLongestSubstring(string) {
    let longestSubstringLength = 0;
    let longestSubstringIndex = 0;
    // Iterate through all characters in the string as possible substring-starting points.
    for (let i = 0; i < string.length; i++) {
        // For each starting character, iterate through the string until a repeat is reached.
        for (let j = i+1; j < string.length; j++) {
            // When a repeat character is reached, check if the substring is the longest one found.
            if (string[i] === string[j]) {
                if (longestSubstringLength < j - i) {
                    longestSubstringLength = j - i;
                    longestSubstringIndex = i;
                }
                break;
            }
        }
    }
    // If a repeat is never found, return the full substring.
    if (longestSubstringLength === 0) {
        return string;
    }
    return string.substring(longestSubstringIndex, longestSubstringIndex + longestSubstringLength)
}

console.log(findLongestSubstring("abcabcbb"))
console.log(findLongestSubstring("aaaaaa"))
console.log(findLongestSubstring("abcde"))
console.log(findLongestSubstring("abcda"))
