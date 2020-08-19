class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        bt(res, s, 1, "");
        return res;
    }
    public void bt(List<String> res, String s, int n, String ip){
        if(n == 5 && s.length() == 0){
            res.add(ip.substring(0, ip.length() - 1));
            return;
        }
        if(n >= 5)
            return;
        int remain = 5 - n;
        if(s.length() < remain || s.length() > (3 * remain))
            return;
        for(int i = 1; i <= 3; i++){
            if(s.length() < i)
                return;
            String part = s.substring(0, i);
            int num = Integer.valueOf(part);
            if(part.length() != String.valueOf(num).length())
                return;
            if(num > 255)   return;
            bt(res, s.substring(i), n + 1, ip + part + ".");
        }
    }
}