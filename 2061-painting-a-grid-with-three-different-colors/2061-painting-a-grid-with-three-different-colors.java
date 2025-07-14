class Solution {
    int mod=(int) 1e9+7;
    //memoization of number of ways according to previous colomn state
    Integer[][] dp = new Integer[1002][1024];
    public int colorTheGrid(int m, int n) {
        helper(m,n,0,0,0,0);
        // final answer stored at dp[0][0]
        return dp[0][0]; 
    }
    public int helper(int m,int n,int r,int c, int prev_state,int cur_state){
        //if all rows in column are done, move to next column
        if(r==m) return helper(m,n,0,c+1,cur_state,0);
        //if all colmns are filled it is a valid configuration
        if(n==c) return 1;
        // if we are at top of column and we have already solvd this column return that
        if(r==0 && dp[c][prev_state]!=null) return dp[c][prev_state];
        // get the color of upper cell
        int up=cur_state&3;
        int ways=0;
        //try coloring cel with 1,2 or 3
        for(int color=1;color<=3;color++){
            //get the color of the left neighbour in same row
            int left=((prev_state>>((m-r-1)*2))&3);
            //make sure that color is not same as top or left
            if(color!=up && color!=left){
                //add this color to the current columns state
                cur_state<<=2;
                cur_state+=color;
                //fill next row
                ways=(ways+helper(m,n,r+1,c,prev_state,cur_state))%mod;
                //backtrack
                cur_state>>=2;
            }
        }
        if(r==0) dp[c][prev_state]=ways;
        return ways;
    }
}