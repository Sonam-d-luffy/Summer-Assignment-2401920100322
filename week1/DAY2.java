import java.util.HashSet;
import java.util.Set;

public class DAY2 {
    public int maxSubArray(int[] nums) {
        //tc = O(n) & sc = O(1);
        int max = nums[0];
        int ans = nums[0];
        for(int i=1;i<nums.length;i++){
            max = Math.max(nums[i] , max+nums[i]);
            ans = Math.max(ans , max);
        }
        return ans;
    }
    public boolean containsDuplicate(int[] nums) {
        //tc = O(n) && sc = O(n)
        Set<Integer> s = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(s.contains(nums[i])) return true;
            s.add(nums[i]);
        }
        return false;
    }
    public double findMaxAverage(int[] nums, int k) {
        //tc = O(N) && sc = O(1)
        int sum =0;
        for(int i=0;i<k;i++){
            sum+=nums[i];
        }
        double ans =(double) sum/k;
        for(int i=k;i<nums.length;i++){
            sum+=nums[i];
            sum-=nums[i-k];
            double avg1 =(double) sum/k;
            ans = Math.max(ans, avg1);
        }
        return ans;
    }
}
