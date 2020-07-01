class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if(num.length() == 0 || num == null) return res;
        bt(res, num, target, "", 0, 0, 0);
        return res;
    }
    
    public void bt(List<String> res, String num, int target, String path, int pos, long eval, long mul){
        if(pos == num.length()){
            if(target == eval)  res.add(path);
            return;
        }
        for(int i = pos; i < num.length(); i++){
            if(i != pos && num.charAt(pos) == '0')  break;
            long cur = Long.parseLong(num.substring(pos, i + 1));
            if(pos == 0)    bt(res, num, target, path + cur, i + 1, cur, cur);
            else{
                bt(res, num, target, path + "+" + cur, i + 1, eval + cur, cur);
                bt(res, num, target, path + "-" + cur, i + 1, eval - cur, -cur);
                bt(res, num, target, path + "*" + cur, i + 1, eval - mul + mul * cur, mul * cur);
            }
        }
        return;
    }
}