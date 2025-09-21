class Solution {
    int n;
    int[] rows;
    int[] cols;
    public int totalNQueens(int n) {
        this.n=n;
        rows= new int[n+1];
        cols= new int[n+1];
        return helper(0);
    }
    public int helper(int i){
        if(i==n) return 1;
        int count=0;
        for(int idx=0;idx<n;idx++){
            if(canPlace(i,idx)){
                rows[i]|=(1<<idx);
                cols[idx]|=(1<<i);
                count+=helper(i+1);
                rows[i]&=~(1<<idx);
                cols[idx]&=~(1<<i);
            }
        }
        return count;
    }
   public boolean canPlace(int i,int col){
        if(cols[col]>0) return false;
        int tempi=i,tempcol=col;
        while(i>=0 && col>=0){
            if((rows[i]&(1<<col))!=0) return false;
            i--;
            col--;
        }
        i=tempi;
        col=tempcol;
        while(i>=0 && col<n){
            if((rows[i]&(1<<col))!=0) return false;
            i--;
            col++;
        }
        return true;
   }
}
