/*
Given a string, we can "shift" each of its letter to its successive letter, 
for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:
"abc" -> "bcd" -> ... -> "xyz"


Given a list of strings which contains only lowercase alphabets, 
group all strings that belong to the same shifting sequence.
For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], Return:
[
  ["abc","bcd","xyz"],
  ["az","ba"],
  ["acef"],
  ["a","z"]
]
Note: For the return value, each inner list's elements must follow the lexicographic
 order.
things to consider: 1 does each group allow duplicates, such as ["a", "a"]. 
2 how to calculate unique hash key.
*/
public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();

        for(String s : strings){
            boolean added =false;
            for(String k : map.keySet()){
                if(k.length() != s.length()) continue;
                if(isShift(k, s)){
                    added = true;
                    map.get(k).add(s);
                }
            }

            if(!added){
                List<String> l = new ArrayList<>();
                l.add(s);
                map.put(s, l);
            }
        }

        return new ArrayList<List<String>>(map.values());
    }

    boolean isShift(String k, String s){
        int prev = (26 + s.charAt(0) - k.charAt(0))%26;
        for(int i=1; i< k.length(); i++){
            int cur = (26 + s.charAt(i) - k.charAt(i))%26;
            if(cur != prev) return false;
            prev = cur;
        }
        return true;
    }
}