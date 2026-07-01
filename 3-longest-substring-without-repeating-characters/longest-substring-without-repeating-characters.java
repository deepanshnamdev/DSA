class Solution {
    public int lengthOfLongestSubstring(String s) {
        int [] hash=new int[256];
        Arrays.fill(hash,-1);
        int l=0;
        int r=0;
        int n=s.length();
        int maxlength=0;
        while(r<n){
            char ch=s.charAt(r);
            if(hash[ch]!=-1){
                if(hash[ch]>=l){
                    l=hash[ch]+1;
                }
            }
            int length=r-l+1;
            maxlength=Math.max(maxlength,length);
            hash[ch]=r;
            r++;
        }
        return maxlength;
    }
}