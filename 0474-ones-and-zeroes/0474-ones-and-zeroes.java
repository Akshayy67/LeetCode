class Solution {
    Integer[][][] dp= new Integer[601][101][101];
    public int findMaxForm(String[] strs, int m, int n) {
        List<int[]> nums= new ArrayList<>();
        for(String s:strs){
            int one=0;
            for(char c:s.toCharArray()){
                one+=(c-'0');
            }
            nums.add(new int[] {s.length()-one,one});
        }
        return helper(0,nums,m,n);
    }
    public int helper(int i,List<int[]> nums,int m,int n){
        if(i==nums.size()) return 0;
        if(dp[i][m][n]!=null) return dp[i][m][n];
        int leave=helper(i+1,nums,m,n);
        int take=0;
        if(m>=nums.get(i)[0] && n>=nums.get(i)[1]) take=1+helper(i+1,nums,m-nums.get(i)[0],n-nums.get(i)[1]);
        return dp[i][m][n]=Math.max(take,leave);
    }
}