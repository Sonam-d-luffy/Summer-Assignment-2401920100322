public class DAY3 {
    public int strStr(String haystack, String needle) {
        // tc= O(n) & sc=O(1)
        if (needle.length() > haystack.length())
            return -1;
        for (int i = 0; i < needle.length(); i++) {
            if (haystack.substring(0, needle.length()).equals(needle))
                return 0;
        }
        for (int i = needle.length(); i < haystack.length(); i++) {
            String s = haystack.substring(i - needle.length() + 1, i + 1);
            if (s.equals(needle))
                return i - needle.length() + 1;
        }
        return -1;
    }

    public boolean isSubsequence(String s, String t) {
        //tc = O(n) & sc=O(1)
        int j=0;
        int k=0;
        if(s.length()>t.length()) return false;
        for(int i=0;i<t.length();i++){
            if(j>=s.length()) break;
            if(t.charAt(i)==s.charAt(j)){
                 k++;
                 j++;
            }
            if(k==s.length()) return true;
        }
        if(k>=s.length()) return true;
        return false;
    }

    public boolean repeatedSubstringPattern(String s) {
        //tc = O(n) & sc=O(1)
        for(int i=1;i<=s.length()/2;i++){
            if(s.length()%i==0){
                if(s.substring(0,i).repeat(s.length()/i).equals(s)) return true;
            }
        }
        return false;
    }
}