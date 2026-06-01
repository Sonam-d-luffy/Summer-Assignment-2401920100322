import java.util.*;

public class DAY1_ARRAY_BASICS {
    public int[] twoSum(int[] nums, int target) {
        //tc = O(n) && sc = O(n)
        Map<Integer,Integer> m = new HashMap<>();
       
        for(int i=0;i<nums.length;i++){
            int n = target-nums[i];
            if(m.containsKey(n)) return new int[] {i,m.get(n)};
            m.put(nums[i],i);
        }
        return new int[] {-1,-1};
    }
     public int removeDuplicates(int[] nums) {
        // tc = O(n) & sc = O(1)
        int i=1;
        int j=1;
        while(i<nums.length){
            if(nums[i]!=nums[j-1]){
                nums[j]=nums[i];
                j++;
            }
            i++;
        }
        return j;
    }

    public int maxProfit(int[] prices) {
        // tc = O(n) & sc = O(1)
        int profit =0;
        int buy = prices[0];
        for(int i=0;i<prices.length;i++){
            int sell = prices[i];
            int currProfit = sell - buy;
            profit = Math.max(profit , currProfit);
            if(prices[i]<buy) buy = prices[i];
        }
        return profit;
    }
}
