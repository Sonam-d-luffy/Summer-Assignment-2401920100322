import java.util.Stack;

public class DAY4 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Integer> s = new Stack<>();
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && temperatures[s.peek()] <= temperatures[i]) {
                s.pop();
            }
            if (s.isEmpty())
                ans[i] = 0;
            else
                ans[i] = s.peek() - i;
            s.push(i);
        }
        return ans;
    }

    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            int ans = 0;
            String s = tokens[i];
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                if (s.equals("+"))
                    ans = b + a;
                if (s.equals("-"))
                    ans = b - a;
                if (s.equals("*"))
                    ans = b * a;
                if (s.equals("/"))
                    ans = b / a;
                stack.push(String.valueOf(ans));
            } else
                stack.push(s);
        }
        return Integer.parseInt(stack.pop());
    }

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> s = new Stack<>();
        int max = Integer.MIN_VALUE;
        for(int i=0;i<=heights.length;i++){
            int e = (i==heights.length) ? 0 : heights[i];
            while(!s.isEmpty() && heights[s.peek()]>e){
                int h = heights[s.pop()];
                int ps = (s.isEmpty()) ? -1 : s.peek();
                int w = i-ps-1;
                int area = h*w;
                max = Math.max(max,area);
            }
            s.push(i);
        }
        return max==Integer.MIN_VALUE ? 0 : max;
    }

}
