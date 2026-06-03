public class DAY3 {
    public void moveZeroes(int[] nums) {
        //tc = O(N) & sc = O(1)
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0) {
                int temp = nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                j++;
            }
        }
    }

    public int[] sortedSquares(int[] nums) {
        //tc = O(N) && sc = O(N)

        int st=0;
        int end = nums.length-1;
        int k = nums.length-1;
        int[] ans = new int[nums.length];

        while(st<=end){
            int l = nums[st]*nums[st];
            int r = nums[end]*nums[end];
            if(l>=r){
                ans[k--]=l;
                st++;
            }else{
                ans[k--]=r;
                end--;
            }
        }
        return ans;
    }

    public int maxArea(int[] height) {
        //tc = O(N) & sc = O(1)
        int max = Integer.MIN_VALUE;
        int l =0;
        int r = height.length-1;
        while(l<r){
            int min = Math.min(height[l],height[r]);
            int width = r-l;
            int area = min*width;
            max = Math.max(max, area);
            if(height[l]<height[r]) l++;
            else r--;
        }
        return max;
    }
}
