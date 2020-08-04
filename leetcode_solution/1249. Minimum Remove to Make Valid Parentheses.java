class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int open = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
            } else if (c == ')') {
                if (open == 0) continue;
                open--;
            }
            sb.append(c);
        }

        // for(int i = 0; i < sb.length() -1 && open > 0; i++){
        //     if(sb.charAt(i) == '('){
        //         sb.deleteCharAt(i);
        //         open--;
        //     }
        // }
        
        for (int i = sb.length() - 1; i >= 0 && open > 0; i--) {
            if (sb.charAt(i) == '(') {
                sb.deleteCharAt(i);
                open--;
            }
        }

        return sb.toString();
    }
}