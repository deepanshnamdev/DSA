class Solution {
    public int xthsmallestelement(Map<Integer,Integer> map,int x){
        int count=0;
        for(int num=-50;num<=50;num++){
            if(map.containsKey(num)){
                count+=map.get(num);
                if(count>=x){
                return num;
                }   
            }
        }
        return 0;
    }
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n=nums.length;
        int i=0;
        int[] result=new int[n-k+1];
        Map<Integer,Integer> map=new HashMap<>();
        for(int j=0;j<n;j++){
            if(nums[j]<0){
                map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            }
            if(j-i+1>k){
                int old=nums[i];
                if(map.containsKey(old)){
                    map.put(nums[i],map.get(old)-1);
                    if(map.get(old)==0){
                    map.remove(old);
                    }
                }
            i++;
            }
            if(j-i+1==k){
                result[i]=xthsmallestelement(map,x);
            }
        }
        return result;
    }
}