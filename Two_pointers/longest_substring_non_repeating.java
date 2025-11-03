package Two_pointers;
import java.util.HashMap;

public class longest_substring_non_repeating {
    // find the longest substring without repeating characters
    public int lenOfSubstring(String s){
        int len = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        while(r<s.length()){
            if(map.containsKey(s.charAt(r))){
                l =Math.max( map.get(s.charAt(r)) + 1,l); // L position should be the max of the rth character's last occurance in the string + 1 and L itself .... for example when r reaches 'b' at its second occurance L is at its previous position = 4, so L will be taken max of B's previous occurance+1 = 1+1 or at 4 
            }
            map.put(s.charAt(r), r);
            len = Math.max(len, r-l+1);
            r++;
        }
        return len;
    }
    public static void main(String[] args) {
        String s = "abcaabcdbb";
        longest_substring_non_repeating sb = new longest_substring_non_repeating();
        System.out.println(sb.lenOfSubstring(s));
    }
}
