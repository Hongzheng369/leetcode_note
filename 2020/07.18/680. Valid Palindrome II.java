/* Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

Example 1:
Input: "aba"
Output: True
Example 2:
Input: "abca"
Output: True
Explanation: You could delete the character 'c'.
 */
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