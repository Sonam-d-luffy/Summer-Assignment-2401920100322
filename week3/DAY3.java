import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
 class DAY3 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char last = s.charAt(i);
            if (!stack.isEmpty()) {
                char curr = stack.peek();
                if (isPair(curr, last)) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(last);
        }
        return stack.isEmpty();
    }

    public boolean isPair(char curr, char last) {
        if ((curr == '(' && last == ')')
                || (curr == '{' && last == '}') ||
                (curr == '[' && last == ']'))
            return true;
        return false;
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        Stack<Integer> s = new Stack<>();
        Map<Integer,Integer> m = new HashMap<>();
        for(int i=nums2.length-1;i>=0;i--){
            while(!s.isEmpty() && s.peek()<=nums2[i]){
                s.pop();
            }
            if(s.isEmpty()) m.put(nums2[i],-1);
            else m.put(nums2[i],s.peek());
            s.push(nums2[i]);
        }
        for(int i=0;i<nums1.length;i++){
            ans[i]=m.getOrDefault(nums1[i],-1);
        }
        return ans;
    }
    
}
class MinStack {
Stack<Integer> s;
int min=Integer.MAX_VALUE;
    public MinStack() {
        s=new Stack<>();
    }
    
    public void push(int val) {
        if(s.isEmpty()|| val<=min){
            s.push(min);
            min=val;
        }
        s.push(val);
    }
    
    public void pop() {
        if(s.isEmpty()) return;
        int a = s.pop();
        if(a==min){
            min=s.pop();
        }
       
    }
    
    public int top() {
        if(!s.isEmpty()) return s.peek();
        return -1;
    }
    
    public int getMin() {
        return min;
    }
    
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */