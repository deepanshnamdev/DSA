class Solution {
    public int function(int[]nums,int k){
        if(k<0)return 0;
        int i=0;
        int j=0;
        int n=nums.length;
        int sum=0;
        int count=0;
        while(j<n){
            if(nums[j]%2==1){
            sum++;
            }
            while(sum>k){
                if(nums[i]%2==1){
                sum--;
                }
                i++;
            }
            count+=j-i+1;
            j++;
        }
        return count;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return function(nums,k)-function(nums,k-1);
    }
}