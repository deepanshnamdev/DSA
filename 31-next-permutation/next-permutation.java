class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int smallelemetfromright=-1;
        for(int i=n-1;i>0;i--){
            if(nums[i]>nums[i-1]){
                smallelemetfromright=i-1;
                break;
            }
        }
        int largestelementformsmallelemetfromright=smallelemetfromright;
        if(smallelemetfromright>-1){
            for(int j=n-1;j>smallelemetfromright;j--){
                if(nums[j]>nums[smallelemetfromright]){
                    largestelementformsmallelemetfromright=j;
                    break;
                }
            }
            int temp=nums[smallelemetfromright];
            nums[smallelemetfromright]=nums[largestelementformsmallelemetfromright];
            nums[largestelementformsmallelemetfromright]=temp;
        }
        int left=smallelemetfromright+1;
        int right=n-1;
        while(left<right){
            int temp= nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;
            right--;
        }
    }
}