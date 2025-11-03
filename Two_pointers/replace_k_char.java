package Two_pointers;

public class replace_k_char {
    // / Function to find the length of longest substring that can be converted
    // into a substring of all same characters by replacing at most k characters
    public int characterReplacement(String s, int k) {
        int l = 0, r = 0;
        int maxCount = 0; // to keep track of the count of the most frequent character in the current window
        int[] count = new int[26]; // assuming only uppercase letters A-Z
        int maxLength = 0;
        while (r<s.length()) {
            count[s.charAt(r)-'A']++;
            maxCount = Math.max(maxCount, count[s.charAt(r)-'A']);
            while(r-l+1 - maxCount > k){ // if the number of characters to be replaced exceeds k, shrink the window from the left
                count[s.charAt(l)-'A']--;
                l++;
            }
            maxLength = Math.max(maxLength, r-l+1);
            r++;
        }
        return maxLength;
    }
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        replace_k_char rk = new replace_k_char();
        System.out.println(rk.characterReplacement(s, k));
    }
}
