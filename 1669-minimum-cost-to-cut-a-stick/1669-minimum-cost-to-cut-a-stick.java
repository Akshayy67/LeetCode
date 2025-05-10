class Solution {
    int[][] dp;
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int[] fake= new int[cuts.length+2];
        dp= new int[fake.length][fake.length];
        for(int[] d:dp) Arrays.fill(d,-1);
        fake[fake.length-1]=n;
        for(int i=0;i<cuts.length;i++) fake[i+1]=cuts[i];
        return helper(fake,0,fake.length-1);
    }
    public int helper(int[] cuts,int i , int j){
        if(j-i<=1) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int min=Integer.MAX_VALUE;
        for(int k=i+1;k<j;k++){
            int cost=helper(cuts,i,k)+helper(cuts,k,j);
            min=Math.min(min,cost);
        }
        return dp[i][j]=min+(cuts[j]-cuts[i]);
    }
}