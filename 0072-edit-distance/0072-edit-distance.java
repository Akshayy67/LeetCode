class Solution {
    String s1,s2;
    Integer[][] dp;
    public int minDistance(String word1, String word2) {
        this.s1=word1;
        this.s2=word2;
        dp= new Integer[s1.length()][s2.length()];
        return helper(0,0);
    }
    public int helper(int i,int j){
        if(j==s2.length()) return s1.length()-i;
        if(i==s1.length()) return s2.length()-j;
        if(dp[i][j]!=null) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)) return helper(i+1,j+1);
        int insert=1+helper(i,j+1);
        int delete=1+helper(i+1,j);
        int replace=1+helper(i+1,j+1);
        return dp[i][j]=Math.min(insert,Math.min(delete,replace));
    }
}