class Solution {
    Map<String, Integer> map = new HashMap<>();
    public List<List<Integer>> palindromePairs(String[] words) {
        int n = words.length;
        for(int i = 0; i < n; i++)
            map.put(words[i], i);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String word = words[i];
            int m = word.length();
            if(m == 0)  continue;
            for(int j = 0; j <= m; j++){
                if(isPalindrome(word, j, m - 1)){
                    int left = findWord(word, 0, j - 1);
                    if(left != -1 && left != i)
                        res.add(Arrays.asList(i, left));
                }
                if(j != 0 && isPalindrome(word, 0, j - 1)){
                    int right = findWord(word, j, m - 1);
                    if(right != -1 && right != i)
                        res.add(Arrays.asList(right, i));
                }
            }
        }
        return res;
    }
    
    public int findWord(String s, int left, int right){
        String tmp = new StringBuilder(s.substring(left, right + 1)).reverse().toString();
        return map.getOrDefault(tmp, -1);
    }
    
    public boolean isPalindrome(String s, int left, int right){
        int len = right - left + 1;
        for(int i = 0; i < len / 2; i++){
            if(s.charAt(left + i) != s.charAt(right - i))
                return false;
        }
        return true;
    }
}