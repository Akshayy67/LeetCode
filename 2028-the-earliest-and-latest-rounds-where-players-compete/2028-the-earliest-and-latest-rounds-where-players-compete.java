class Solution {
    int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    int n;
    public int[] earliestAndLatest(int n, int fp, int sp) {
        int seq= (1<<n)-1;
        this.n=n;
        helper(seq,fp-1,sp-1,1,0,n-1);
        return new int[] { min, max };
    }

    public void helper(int seq, int fp, int sp, int count,int i,int j) {
         if(i>=j){
            helper(seq,fp,sp,count+1,0,n-1);
        }
        else if((seq&(1<<i))==0){
            helper(seq,fp,sp,count,i+1,j);
        }
        else if((seq&(1<<j))==0){
            helper(seq,fp,sp,count,i,j-1);
        }
        else if((i==fp && j==sp) || (i==sp && j==fp)){
            max=Math.max(max,count);
            min=Math.min(min,count);
        }
        else{
            if(i!=fp && i!=sp){
                helper(seq&~(1<<i),fp,sp,count,i+1,j-1);
            }
            if(j!=fp && j!=sp){
                helper(seq&~(1<<j),fp,sp,count,i+1,j-1);
            }
        }
    }
}