class Solution {
   int[] mapping = new int[26];
    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < order.length(); i++)
            mapping[order.charAt(i) - 'a'] = i;
        for (int i = 1; i < words.length; i++)
            if (compare(words[i - 1], words[i]) > 0)
                return false;
        return true;
    }

    public int compare(String s1, String s2) {
        int m = s1.length(), n = s2.length(), cmp = 0;
        for (int i = 0, j = 0; i < m && j < n && cmp == 0; i++, j++) {
            cmp = mapping[s1.charAt(i) - 'a'] - mapping[s2.charAt(j) - 'a'];
            //cmp = s1.charAt(i) - s2.charAt(j);
        }
        return cmp == 0 ? m - n : cmp;
    }
}   