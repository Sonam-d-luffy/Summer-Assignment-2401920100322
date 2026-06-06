public class DAY1{
    public boolean isAnagram(String s, String t) {
        //tc=O(n) && sc=O(1)
        if(s.length()!=t.length()) return false;

        int[] f1 = new int[26];
        int[] f2 = new int[26];
        for(int i=0;i<s.length();i++){
            f1[s.charAt(i)-'a']++;
            f2[t.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++){
            if(f1[i]!=f2[i]) return false;
        }
        return true;
    }

    public int firstUniqChar(String s) {
        //tc=O(n) & sc=O(1)
        int[] freq = new int[26];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }
        for(int i=0;i<s.length();i++){
            int n = freq[s.charAt(i)-'a'];
            if(n==1) return i;
        }
        return -1;
    }
}