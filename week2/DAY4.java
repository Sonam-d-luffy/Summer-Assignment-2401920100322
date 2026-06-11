import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DAY4{
    public String reverseWords(String s) {
        //tc=O(n) & sc = O(n)
        String[] str = s.split(" ");
        StringBuilder ans = new StringBuilder("");
        for(int i=0;i<str.length;i++){
            StringBuilder string = new StringBuilder(str[i]).reverse();
            ans.append(string);
            ans.append(" ");
        }
        ans.deleteCharAt(ans.length()-1);
        return ans.toString();
    }

    public String decodeString(String s) {
        //tc=O(n) & sc=O(1)
        StringBuilder ans = new StringBuilder("");
        Stack<Integer> s1 = new Stack<>();
        Stack<StringBuilder> s2 = new Stack<>();
        int n=0;
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                n = n*10 + (c-'0');
            }
            else if(c=='['){
                s1.push(n);
                s2.push(ans);
                n=0;
                ans = new StringBuilder("");
            }else if(c==']'){
                int num = s1.pop();
                StringBuilder str = ans;
                ans = s2.pop();
                for(int i=0;i<num;i++){
                    ans.append(str);
                }
            }else{
                ans.append(c);
            }
        }
        return ans.toString();
    }

    public List<String> generateParenthesis(int n) {
        //tc=O(2^(2n)) & sc=O(n) + recursion stack
        List<String> ans = new ArrayList<>();
        generate(n,0,0,new StringBuilder(""),ans);
        return ans;
    }
    public void generate(int n, int open, int close,StringBuilder s, List<String> ans){
        if(open==n && close==n){
            ans.add(s.toString());
            return;
        }
        if(open<n && open>=close){
            generate(n,open+1,close,s.append('('),ans);
            s.deleteCharAt(s.length()-1);
        }
        if(close<n && close<open){
            generate(n,open,close+1,s.append(')'),ans);
            s.deleteCharAt(s.length()-1);
        }
    }
}
