/*
247. Strobogrammatic Number II
A strobogrammatic number is a number that looks the same 
when rotated 180 degrees (looked at upside down).

Find all strobogrammatic numbers that are of length = n. 
For example,
Given n = 2, return ["11","69","88","96"].

*/
public class Solution {
    public List<String> findStrobogrammatic(int n) {
        return helper(n, n);
    }
    public List<String> helper(int targetLen, int totalLen) {
        if (targetLen == 0) {
            return new ArrayList(Arrays.asList(""));
        }
        if (targetLen == 1) {
            return new ArrayList(Arrays.asList("1", "8", "0"));
        }
        List<String> sub = helper(targetLen - 2, totalLen);
        List<String> result = new ArrayList<>();
        for (String str : sub) {
            if (targetLen != totalLen) {
                result.add("0" + str + "0");
            }
            result.add("1" + str + "1");
            result.add("6" + str + "9");
            result.add("9" + str + "6");
            result.add("8" + str + "8");
        }
        return result;
    }
}