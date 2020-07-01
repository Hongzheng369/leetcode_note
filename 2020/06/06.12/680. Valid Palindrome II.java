class Solution {
    public boolean validPalindrome(String s) {
        if(s.length() == 0) return false;
        int i = 0, j = s.length() -1;
        //int count = 0;
        while(i <= j ){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
                //continue;
            }
            else{
                return helper(s,i+1, j) || helper(s, i, j -1);
            }
           
        }
        return true;
    }
    
    public boolean helper(String s, int i, int j){
        while( i <= j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }else
                return false;
        }
        return true;
    }
}