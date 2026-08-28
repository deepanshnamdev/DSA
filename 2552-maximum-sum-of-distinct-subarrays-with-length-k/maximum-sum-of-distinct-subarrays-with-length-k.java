class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        if(nums.length==0){
            return 0;
        }
        int n=nums.length;
        long sum=0;
        long result=0;
        Set<Integer> set = new HashSet<>();
        int i=0;
        int j=0;
        while(j<n){
            while(set.contains(nums[j])){
                sum-=nums[i];
                set.remove(nums[i]);
                i++;
            }
            sum+=nums[j];
            set.add(nums[j]);
            if(j-i+1==k){
                result=Math.max(result,sum);
                sum-=nums[i];
                set.remove(nums[i]);
                i++;
            }
            j++;
        }
        return result;
    }
}