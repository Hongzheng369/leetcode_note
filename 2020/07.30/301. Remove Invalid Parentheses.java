/* Example 1:

Input: "()())()"
Output: ["()()()", "(())()"]
Example 2:

Input: "(a)())()"
Output: ["(a)()()", "(a())()"]
Example 3:

Input: ")("
Output: [""] */
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        //if(s.length() == 0) return res;
        bt(res, s, 0, 0, '(', ')');
        return res;
    }
    
    public void bt(List<String> res, String s, int iStart, int jStart, char open, char close){
        int numOpen = 0, numClose = 0;
        for(int i = iStart; i < s.length(); i++){
            if(s.charAt(i) == open) numOpen++;
            if(s.charAt(i) == close) numClose++;
            if(numClose > numOpen){
                for(int j = jStart; j <= i; j++){
                    if(s.charAt(j) == close && (j == jStart || s.charAt(j - 1) != close))
                        bt(res, s.substring(0,j) + s.substring(j+1), i, j, open, close);
                
                
                }
                return;
            }
        }
        String reverse = new StringBuilder(s).reverse().toString();
        if(open == '(')
            bt(res, reverse, 0, 0, ')', '(');
        else
            res.add(reverse);
    }
}