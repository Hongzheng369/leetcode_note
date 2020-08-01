/* Example 1:

Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
Example 2:

Input: s = "a)b(c)d"
Output: "ab(c)d"
Example 3:

Input: s = "))(("
Output: ""
Explanation: An empty string is also valid.
Example 4:

Input: s = "(a(b(c)d)"
Output: "a(b(c)d)" */
class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int open = 0;
        for(char c: s.toCharArray()){
            if(c == '('){
                open++;
            }
            else if(c == ')'){
                if(open == 0) continue;
                open--;
            }
            sb.append(c);
        }
        for(int i = sb.length() - 1; i >= 0 && open > 0; i--){
            if(sb.charAt(i) == '('){
                sb.deleteCharAt(i);
                open--;
            }
        }
        return sb.toString();
    }
}