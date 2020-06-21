class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        return helper(s, set);
    }
    
    private boolean helper(String s, Set<String> set){
        if(s.length() == 0)    return true;
        for(int i = 0; i <= s.length(); i++){
            if(set.contains(s.substring(0, i)) && helper(s.substring(i), set))  return true;
        }
        return false;
    }
}