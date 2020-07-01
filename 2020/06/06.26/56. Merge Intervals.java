class Solution{
    public int[][] merge(int[][] intevals){
        //List<int[]> res = new ArrayList<>();
        int n = intevals.length;
        int[] start = new int[n];
        int[] end = new int[n];
        for(int i = 0; i < n; i++){
            start[i] = intevals[i][0];
            end[i] = intevals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        List<int[]> res = new ArrayList<>();
        for(int i = 0, j = 0; i < n; i++){
            if(i == n - 1 || start[i + 1] > end[i]){
                res.add(new int[]{start[j], end[i]});
                j = i + 1;
            }
        }
        return res.toArray(new int[res.size()][2]);
    }
}