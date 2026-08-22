class Solution {
    public int findMiddleIndex(int[] nums) {
        int n=nums.length;
        int totalsum=0;
        for(int i=0;i<n;i++){
            totalsum+=nums[i];
        }
        // totalsum=rightsum+nums[i]+leftsum;
        // rightsum=totalsum-nums[i]-leftsum;
        int leftsum=0;
        int rightsum=0;
        for(int i=0;i<n;i++){
            rightsum=totalsum-nums[i]-leftsum;
            if(leftsum == rightsum){
                return i;
            }
            leftsum+=nums[i];
        }
        return -1;
    }
}