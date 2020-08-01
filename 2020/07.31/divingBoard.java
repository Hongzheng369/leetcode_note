class Solution{
    public int[] divingBoard(int short, int long, int k){
        if(k <= 0)  return new int[0];
        if(short == long)   return new int[]{short * k};
        int[] lengths = new int[k + 1];
        for(int i = 0; i <= k; i++){
            lengths[i] = short * (k - i) + long * i;
        }
        return lengths;
    }
}