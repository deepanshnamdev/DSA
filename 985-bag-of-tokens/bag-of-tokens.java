class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int n=tokens.length;
        int i=0;
        int j=n-1;
        int maxscore=0;
        int score=0;
        Arrays.sort(tokens);
        while(i<=j){
            if(power>=tokens[i]){
                power-=tokens[i];
                score++;
                i++;
                maxscore=Math.max(maxscore,score);
            }
            else if(power<tokens[i] && score>0){
                score--;
                power+=tokens[j];
                j--;
            }
            else {
                break;
            }
        }
        return maxscore;
    }
}