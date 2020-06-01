class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        set.addAll(wordList);
        return bfs(beginWord, endWord, set);
    }
    private int bfs(String beginWord, String endWord, Set<String> wordList) {
        int ans = 0;
        Set<String> cur = new HashSet<>();
        Set<String> prev = new HashSet<>();
        cur.add(beginWord);
        while(!cur.isEmpty() && !cur.contains(endWord)) {
            ans++;
            Set<String> next = new HashSet<>();
            for (String s : cur) {
                StringBuilder sb = new StringBuilder(s);
                for (int i = 0; i < sb.length(); i++) {
                    char init = sb.charAt(i);
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c != sb.charAt(i)) {
                            sb.setCharAt(i, c);  
                            String ns = sb.toString();
                            if (wordList.contains(ns) && !prev.contains(ns)) {
                                wordList.remove(ns);
                                next.add(ns);
                            }
                        }
                    }
                    sb.setCharAt(i, init); 
                }
                prev.add(s);
            }
            cur = next;
        }
        return cur.isEmpty() ? 0 : ans + 1;
    }
}