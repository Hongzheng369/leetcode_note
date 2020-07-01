class Solution{
    public String alienOrder(String[] words){
        HashMap<Character, Set<Character>> map = new HashMap<>();
        HashMap<Character, Character> degree = new HashMap<>();
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < order.length; i++){
            char[] word = words[i].toCharArray();
            for(int j = 0; j < word.length; j++)
                degree.put(word[j], 0);
        }

        for(int i = 0; i < words.length - 1; i++){
            String cur = words[i];
            String next = words[i + 1];
            int len = Math.min(cur.length(), next.length());
            for(int j = 0; j < len; j++){
                char c1 = cur.charAt(j);
                char c2 = next.charAt(j);
                if(c1 != c2){
                    Set<Character> set = new HashSet<>();
                    if(map.containsKey(c1)) set = map.get(c1);
                    if(!set.contains(c2)){
                        set.add(c2);
                        map.put(c1, set);
                        degree.put(c2, degree.get(c2) + 1);
                    }
                    break;
                }else{
                    if(j + 1 == next.length() && j + 1 < cur.length())
                        return "";
                }
            }
        } 
        Queue<Character> queue = new LinkedList<>();
        for(char c: degree.keyset()){
            if(degree.get(c) == 0)  queue.add(c);
        }
        while(!queue.isEmpty()){
            char cur = queue.remove();
            res.append(cur);
            if(map.containsKey(cur)){
                for(char c: map.get(cur)){
                    degree.put(c, degree.get(c) - 1);
                    if(degree.get(c) == 0)  queue.add(c);
                }
            }
        }
        if(res.length() != degree.size())   return "";
        return res.toString();
    }
}