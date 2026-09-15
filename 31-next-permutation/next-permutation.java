class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int small_elemet_from_right=-1;
        for(int i=n-1;i>0;i--){
            if(nums[i]>nums[i-1]){
                small_elemet_from_right=i-1;
                break;
            }
        }
        int largest_element_form_small_elemet_from_right=small_elemet_from_right;
        if(small_elemet_from_right>-1){
            for(int j=n-1;j>small_elemet_from_right;j--){
                if(nums[j]>nums[small_elemet_from_right]){
                    largest_element_form_small_elemet_from_right=j;
                    break;
                }
            }
            int temp=nums[small_elemet_from_right];
            nums[small_elemet_from_right]=nums[largest_element_form_small_elemet_from_right];
            nums[largest_element_form_small_elemet_from_right]=temp;
        }
        int left=small_elemet_from_right+1;
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