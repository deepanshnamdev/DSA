class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int n=s.length();
        int i=0;
        int j=0;
        String curr="";
        List<String> ans=new ArrayList<>();
        Map<String, Integer> map=new HashMap<>();
        while(j<n){
            curr+=s.charAt(j);
            if(j-i+1==10){
                if(map.containsKey(curr)){
                    if(map.get(curr)==1){
                        ans.add(curr);
                    }
                }
                map.put(curr, map.getOrDefault(curr, 0) + 1);
                curr=curr.substring(1);
                i++;
            }
            j++;
        }
        return ans;
    }
}