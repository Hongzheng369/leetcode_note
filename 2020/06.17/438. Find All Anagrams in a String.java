class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(s.length() < p.length()) return res;
        int begin = 0, end = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c: p.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int count = map.size();
        while(end < s.length()){
            char c = s.charAt(end);
            if(map.containsKey(c)){
                map.put(c, map.get(c) - 1);
                if(map.get(c) == 0) count--;
            }
            end++;
            
            while(count == 0){
                char tempc = s.charAt(begin);
                if(map.containsKey(tempc)){
                    map.put(tempc, map.get(tempc) + 1);
                    if(map.get(tempc) > 0)  count++;
                }
                if(end - begin == p.length())   res.add(begin);
                begin++;
            }
        }
        return res;
    }
}


class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int left = 0;
        int right = 0;
        int sLen = s.length();
        int pLen = p.length();
        int[] hash = new int[256];
        List<Integer> pos = new ArrayList<Integer>();
        
        for (int i = 0; i<pLen; i++) {
            hash[(int)p.charAt(i)]++;
        }
        int count = 0;
        
        while (right < sLen) {
            if (hash[s.charAt(right)] > 0) {
                hash[s.charAt(right)]--;
                count++;
                right++;
            } else {
                hash[s.charAt(left)]++;
                count--;
                left++;
            }

            if(count == pLen) {
                pos.add(left);
            }
            
        }
        return pos;
    }
}