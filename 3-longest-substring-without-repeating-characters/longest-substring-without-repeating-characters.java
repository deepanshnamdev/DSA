class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0;
        int j=0;
        int n=s.length();
        int ans=0;
        Set<Character> set=new HashSet<>();
        while(j<n){
                char ch=s.charAt(j);
                while(set.contains(ch)){
                    set.remove(s.charAt(i));
                    i++;
                }
                set.add(ch);
                ans=Math.max(ans,j-i+1);
                j++;
        }
        return ans;
    }
}