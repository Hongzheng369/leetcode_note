class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";
        Map<Character, Integer> map = new HashMap<>();
        for(char c: t.toCharArray())
            map.put(c, map.getOrDefault(c,0) + 1);
        int count = map.size();
        int begin = 0 ,end = 0;
        int head = 0;
        int len = Integer.MAX_VALUE;
        
        while(end < s.length()){
            char c = s.charAt(end);
            if(map.containsKey(c)){
                map.put(c, map.get(c) - 1);
                if(map.get(c) == 0)
                    count--;
            }
            end++;
            while(count == 0){
                char temp = s.charAt(begin);
                if(map.containsKey(temp)){
                    map.put(temp, map.get(temp) + 1);
                    if(map.get(temp) > 0)
                        count++;
                }
                if(end - begin < len){
                    len = end - begin;
                    head = begin;
                }
                begin++;
            }
        }
        if(len == Integer.MAX_VALUE) return "";
        return s.substring(head, head + len);
        
    }
}