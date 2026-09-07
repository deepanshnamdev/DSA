class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i=0;
        int j=0;
        // List<Integer> list=new ArrayList<>();
        int ans=0;
        int n=nums.length;
        int m=Integer.MAX_VALUE;
        while(j<n){
            // list.add(nums[j]);
            ans+=nums[j];
            while(ans>=target){
                m=Math.min(m,j-i+1);
                ans-=nums[i];
                // list.remove(0);
                i++;
            }
            j++;
        }
        return m==Integer.MAX_VALUE?0:m;
    }
}