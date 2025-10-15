class Solution {
    List<List<Integer>> triangle;
    Map<String,Integer> dp;
    public int minimumTotal(List<List<Integer>> triangle) {
        this.triangle=triangle;
        dp= new HashMap<>();
        return helper(0,0);
    }
    public int helper(int i,int j){
        if(i==triangle.size()) return 0;
        String key=i+" "+j;
        if(dp.containsKey(key)) return dp.get(key);
        int first=triangle.get(i).get(j)+helper(i+1,j);
        int second=triangle.get(i).get(j)+helper(i+1,j+1);
        dp.put(key,Math.min(first,second));
        return dp.get(key);
    }
}