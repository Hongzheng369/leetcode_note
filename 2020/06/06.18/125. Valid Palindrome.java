class Solution {
    public boolean isPalindrome(String s) {
        if(s.length() == 0) return true;
        int i = 0, j = s.length() - 1;
        char left, right;
        while(i <= j){
            left = s.charAt(i); right = s.charAt(j);
            if(!Character.isLetterOrDigit(left))    i++;
            else if(!Character.isLetterOrDigit(right))   j--;
            else{
                if(Character.toLowerCase(left) == Character.toLowerCase(right)){
                    i++;
                    j--;
                }else{return false;}
            }
        }
        return true;
    }
}