class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        return helper(s, true, true);
    }
    private boolean helper(String s, boolean cpd, boolean cpe) {
        if (s.startsWith("-") || s.startsWith("+")) {
            s = s.substring(1);
        }
        int pN = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '.' && cpd) {
                cpd = false;
            } else if (c == 'e' && pN > 0 && cpe) {
                return helper(s.substring(i+1), false, false);
            } else if (c < '0' || c > '9') {
                return false;
            } else {
                pN++;
            }
        }
        return pN != 0;
    }
}