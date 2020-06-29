class Solution{
    public String reorganizeString(String s){
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        int[] m = new int[26];
        for(int i = 0; i < s.length(); i++)
            m[s.charAt(i) - 'a']++;
        for(int i = 0; i < 26; i++){
            if(m[i] != 0)   q.offer(new int[]{i, m[i]});
        }
        int[] prev = new int[]{-1, 0};
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(prev[1] > 0) q.offer(prev);
            sb.append((char) (cur[0] + 'a'));
            cur[1]--;
            prev = cur;
            if(q.isEmpty() && prev[1] > 0)  return "";
        }
        return sb.toString();
    }
}