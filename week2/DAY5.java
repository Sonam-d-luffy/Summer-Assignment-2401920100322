import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DAY5{

    public List<List<String>> groupAnagrams(String[] strs) {
        //tc = O(n*k) & sc=O(n)
        Map<String,List<String>> m = new HashMap<>();
        for (String str : strs) {
            int[] freq = new int[26];
            String s = str;
            for(char c : s.toCharArray()){
                freq[c-'a']++;
            }
            String key = Arrays.toString(freq);
            m.computeIfAbsent(key,k-> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(m.values());
    }

    
    public int compress(char[] chars) {
        //tc = O(n) & sc = O(1)
        char ch = chars[0];
        int c=1;
        int j=0;
        for(int i=1;i<chars.length;i++){
            if(chars[i]==ch) c++;
            else{
                chars[j++]=ch;
                if(c>1){
                   for(char chr : String.valueOf(c).toCharArray()){
                    chars[j++]=chr;
                   }
                }
                ch = chars[i];
                c=1;
            }
        }
        chars[j++]=ch;
        if(c>1){
            for(char chr : String.valueOf(c).toCharArray()){
                    chars[j++]=chr;
                   }
        }
        return j;
    }
    public String longestPalindrome(String s) {
        //tc = O(n^2) & sc = O(1)
        int st=0;
        int end=0;
        int max=0;
        for(int i=0;i<s.length();i++){
            int odd=expand(s,i,i);
            int even=expand(s,i,i+1);
            max=Math.max(odd,even);
            if(max>end-st){
                st=i-(max-1)/2;
                end=i+max/2;
            }
        }
            return s.substring(st,end+1);

    }
    public static int expand(String s, int l , int r){
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }
        return r-l-1;
    }
}
