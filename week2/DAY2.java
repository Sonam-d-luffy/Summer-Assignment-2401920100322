import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DAY2{
    public int lengthOfLongestSubstring(String s) {
        //tc = O(N) & sc=O(N)
        int j=0;
        int ans = 0;
        Set<Character> set = new HashSet<>();
        for(int i=0;i<s.length();i++){
            while(set.contains(s.charAt(i))){
                set.remove(s.charAt(j));
                j++;
            }
            set.add(s.charAt(i));
            int len = i-j+1;
            ans = Math.max(ans, len);
        }
        return ans;
    }

    public boolean checkInclusion(String s1, String s2) {
        //tc=O(N) & sc=O(1)
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        if(s2.length()<s1.length()) return false;
        for(int i=0;i<s1.length();i++){
            freq1[s1.charAt(i)-'a']++;
            freq2[s2.charAt(i)-'a']++;
        }
        if(Arrays.equals(freq1,freq2)) return true;
        for(int i=s1.length();i<s2.length();i++){
            freq2[s2.charAt(i)-'a']++;
            freq2[s2.charAt(i-s1.length())-'a']--;
            if(Arrays.equals(freq1,freq2)) return true;
        }
        return false;
    }

    public List<Integer> findAnagrams(String s, String p) {
        //tc = O(n) & sc = O(1) excluding output list
        List<Integer> ans = new ArrayList<>();
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        if(p.length()>s.length()) return ans;
        for(int i=0;i<p.length();i++){
            freq1[p.charAt(i)-'a']++;
            freq2[s.charAt(i)-'a']++;
        }
        if(Arrays.equals(freq1,freq2)) ans.add(0);
        for(int i=p.length();i<s.length();i++){
            freq2[s.charAt(i)-'a']++;
            freq2[s.charAt(i-p.length())-'a']--;
            if(Arrays.equals(freq1,freq2)) ans.add(i-p.length()+1);
        }
        return ans;
    }
}