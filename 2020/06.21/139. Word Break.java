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

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        return helper(s, set);
    }
    

    public boolean helper(String s, Set<String> dict) {
        
        boolean[] f = new boolean[s.length() + 1];        
        f[0] = true;                
        /* First DP
        for(int i = 1; i <= s.length(); i++){
            for(String str: dict){
                if(str.length() <= i){
                    if(f[i - str.length()]){
                        if(s.substring(i-str.length(), i).equals(str)){
                            f[i] = true;
                            break;
                        }
                    }
                }
            }
        }*/
        
        //Second DP
        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
                if(f[j] && dict.contains(s.substring(j, i))){
                    f[i] = true;
                    break;
                }
            }
        }
        
        return f[s.length()];
    }
}

