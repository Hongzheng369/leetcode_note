class WordDictionary {
    class TrieNode{
        public TrieNode[] children = new TrieNode[26];
        public String item = "";
    }
    private TrieNode root = new TrieNode();

    /** Initialize your data structure here. */
    public WordDictionary() {
        
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        for(char c: word.toCharArray()){
            if(node.children[c - 'a'] == null)  node.children[c - 'a'] = new TrieNode();
            node = node.children[c - 'a'];
        }
        node.item = word;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return match(word.toCharArray(), 0, root);
    }
    
    private boolean match(char[] chs, int k, TrieNode root){
        if(k == chs.length) return !root.item.equals("");
        if(chs[k] != '.')   return root.children[chs[k] - 'a'] != null && match(chs, k + 1, root.children[chs[k] - 'a']);
        else{
            for(int i = 0; i < root.children.length; i++){
                if(root.children[i] != null){
                    if(match(chs, k + 1, root.children[i])) return true;
                }
            }
        }
        return false;
    }  
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */