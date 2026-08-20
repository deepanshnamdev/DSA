class Solution {
    public int[][] merge(int[][] intervals) {
        // pahale array ko sort krdo
        Arrays.sort(intervals,(a,b)-> Integer.compare(a[0], b[0]));
        //list bana lo
        List<int[]> ans=new ArrayList<>();
        // for ka loop chala lo
        for(int i=0;i<intervals.length;i++){
            // agar second interval ka first value bada hai first interval ke second value se toh no overlap
        if(ans.isEmpty()||intervals[i][0]>ans.get(ans.size()-1)[1]){
            ans.add(intervals[i]);
        }
        // verna overlap 
        else{
            ans.get(ans.size()-1)[1]=Math.max(ans.get(ans.size()-1)[1],intervals[i][1]);
            }     
        }
        // last me array me convert krke return krdo
        
        return ans.toArray(new int[ans.size()][]);
    }
}