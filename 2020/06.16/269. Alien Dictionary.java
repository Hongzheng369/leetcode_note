Class Solution{
    public String alienDic(String[] words){
        StringBuilder sb = new StringBuilder();
        HashMap<Character, HashSet<Character>> map = new HashMap<>();
        HashMap<Character, Character> degree = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            for(int j = 0; j < words[i].length(); j++){
                map.put(words[i].charAt(j), 0);
            }
        }
        for(int i = 0; i < words.length - 1; i++){
            char[] c1 = words[i].toCharArray();
            char[] c2 = words[i+1].toCharArray();
            int len = Math.min(c1.length, c2.length);
            for(int j = 0; j < len; j++){
                if(c1[j] != c2[j]){
                    HashSet<Character> set = new HashSet<>();
                    if(map.containsKey(c1))
                        set = map.get(c1);
                    if(!set.contains(c2)){
                        set.add(c2[j])
                        map.put(c1[j],set);
                        degree.put(c2[j], degree.get(c2[j]) + 1);  
                    }
                    break;
                }else{
                    if(j == c2.length && j < c1.length) return "";
                }
                
            }
        }
        Queue<Character> queue = new Queue<>();
        for(char c: degree.keySet()){
            if(degree.get(c) == 0)  queue.add(c);
        }
        while(!queue.isEmpty()){
            char c1 = queue.remove();
            sb.append(c1);
            //for(char)
            if(map.containsKey(c1)){
                for(char c: map.get(c1)){
                    degree.put(c, degree.get(c) - 1);
                    if(degree.get(c) == 0) queue.add(c);
                }
            }
        }
        if(sb.length() != degree.size()) return "";
        return sb.toString();
    }
}