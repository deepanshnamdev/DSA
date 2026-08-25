class Solution {
    public int waysToSplitArray(int[] nums) {
        long n=nums.length;
        long leftsum=0;
        long totalsum=0;
        for(int i=0;i<n;i++){
            totalsum+=nums[i];
        }
        int count=0;
        for(int i=0;i<n-1;i++){
            leftsum+=nums[i];
            totalsum-=nums[i];
            if(leftsum>=totalsum){
                count++;
            }
        }
        return count;
    }
}