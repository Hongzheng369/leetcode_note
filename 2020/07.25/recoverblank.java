class Solution{
    public int respace(String[] dict, String sentence){
        int[] dp = new int[sentence.length() + 1];
        int right = 1;
        while(right <= sentence.length()){
            dp[right] = dp[right - 1];
            for(String word: dict){
                if(right < word.length) continue;
                String tmp = sentence.substring(right - word.length(), right);
                if(!tmp.equals(word))   continue;
                dp[right] = Math.max(dp[right], dp[right - word.length()] + word.length());
            }
            right++;
        }
        return sentence.length() - dp[sentence.length()];
    }
}