class Solution {
    Integer[][] dp;
    public int longestPalindromeSubseq(String s) {
        dp= new Integer[s.length()][s.length()];
        return helper(s,new StringBuilder(s).reverse().toString(),0,0);
    }
    public int helper(String s1,String s2,int i,int j){
        if(i==s1.length()) return 0;
        if(j==s2.length()) return 0;
        if(dp[i][j]!=null) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)) return 1+helper(s1,s2,i+1,j+1);
        int leave=helper(s1,s2,i+1,j);
        int take=helper(s1,s2,i,j+1);
        return dp[i][j]=(leave>take?leave:take);
    }
}