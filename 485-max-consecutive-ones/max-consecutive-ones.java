class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n=nums.length;
        int j=0;
        int count=0;
        int ans=0;
        while(j<nums.length){
            if(nums[j]==1){
                count++;
                ans=Math.max(ans,count);
            }
            else{
                count=0;
            }
            j++;
        }
        return ans;
    }
}