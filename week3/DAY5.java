import java.util.Stack;

class DAY5{
    Stack<Integer> s1=new Stack<>();
    Stack<Integer> s2=new Stack<>();
    public MyQueue() {
        Stack<Integer> s = s1;
        
    }
    
    public void push(int x) {
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        s1.push(x);
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
    }
    
    public int pop() {
        int x = s1.pop();
        return x;
    }
    
    public int peek() {
       return s1.peek();
    }
    
    public boolean empty() {
        return s1.isEmpty();
    }
}
class RecentCounter {
    int[] nums = new int[10000];
    int st;
    int end;
    public RecentCounter() {
        st=0;
        end=0;
    }
    
    public int ping(int t) {
        while(st<end && (t-nums[st]>3000)) st++;
        nums[end++]=t;
        return end-st;
    }
}