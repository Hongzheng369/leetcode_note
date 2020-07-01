class Solution {
    public String crackSafe(int n, int k) {
        int max = (int)Math.pow(k,n);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            sb.append(0);
        }
        Set<String> set = new HashSet<>();
        set.add(sb.toString());
        dfs(set, sb, max, n, k);
        return sb.toString();
    }
    
    public boolean dfs(Set<String> set, StringBuilder sb, int max, int n, int k){
        if(set.size() == max) return true;
        String prefix = sb.substring(sb.length() - (n - 1), sb.length());
        for(int i = 0; i < k; i++){
            String test = prefix + i;
            if(!set.contains(test)){
                set.add(test);
                sb.append(i);
                if(dfs(set, sb, max, n, k))
                    return true;
                else{
                    sb.deleteCharAt(sb.length() - 1);
                    set.remove(test);
                }                
            }
        }
        return false;
    }
}