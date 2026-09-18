class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int i=0;
        int j=n-1;
        int water_store=0;
        int max_water_store=0;
        while(i<j){
            water_store=Math.min(height[i],height[j])*(j-i);
            max_water_store=Math.max(water_store,max_water_store);
            if(height[i]<height[j]){
                i++;
            }
            else{
                j--;
            }
        }
        return max_water_store;
    }
}