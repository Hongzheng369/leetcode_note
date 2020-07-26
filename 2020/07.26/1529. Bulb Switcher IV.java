class Solution {
    public int minFlips(String target) {
        int ans = 0;
        int cur = 0;
        for(char c: target.toCharArray()){
            if(c - '0' != cur){
                cur ^= 1;
                ans++;
            }
        }
        return ans;
    }
}