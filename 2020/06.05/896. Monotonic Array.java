class Solution {
    public boolean isMonotonic(int[] A) {
       int up = 1; int down = 1;
        for(int i=1; i<A.length;i++){
            if(A[i]>A[i-1]) 
                up++;
            else if(A[i] < A[i-1])
                down++;
            else{
             up++;
             down++; 
            } 
        }
        return up == A.length || down == A.length;
    }
}