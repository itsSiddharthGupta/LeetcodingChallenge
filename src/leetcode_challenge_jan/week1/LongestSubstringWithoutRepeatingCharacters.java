package leetcode_challenge_jan.week1;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0)
            return 0;
        if(s.length() == 1)
            return 1;
        int maxLen = 1, n = s.length();
        int i = 0, j = 0;
        HashMap<Character, Integer> set = new HashMap<>();
        while(i<n && j<n){
            if(set.containsKey(s.charAt(j))){
                i = Math.max(set.get(s.charAt(j)), i);
            }
            //used j+1 so that move i to next character of jth index
            set.put(s.charAt(j), j+1);
            maxLen = Math.max(maxLen, j - i + 1);
            j++;
        }
        return maxLen;
    }
}
