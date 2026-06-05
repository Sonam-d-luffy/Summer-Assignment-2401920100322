import java.util.Arrays;

public class DAY5{
    public boolean isPalindrome(String s) {
        //tc=O(N) & sc = O(1)
        if(s.isEmpty()) return false;
        int i=0;
        int j=s.length()-1;
        while(i<=j){
            char c1 = s.charAt(i);
            char c2 = s.charAt(j);
            if(!Character.isLetterOrDigit(c1))i++;
            else if(!Character.isLetterOrDigit(c2))j--;
            else{
                if(Character.toLowerCase(c1)!=Character.toLowerCase(c2)) return false;
                i++;
                j--;
            }
        }
        return true;
    }
    public void reverseString(char[] s) {
        //tc = O(N) & sc=O(1)
        int i=0;
        int j=s.length-1;
        while(i<=j){
            char temp = s[i];
            s[i]=s[j];
            s[j]=temp;
            i++;
            j--;
        }
    }
    public String longestCommonPrefix(String[] strs) {
        //tc=O(nlogn*m) && sc = O(m)
        Arrays.sort(strs);
        String s = strs[0];
        StringBuilder ans = new StringBuilder("");
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=strs[strs.length-1].charAt(i)){
                return s.substring(0,i);
            }
            ans.append(s.charAt(i));
        }
        return ans.toString();
    }
}