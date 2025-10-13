class Solution {
    Map<Integer,Integer> mp;
    public int climbStairs(int n) {
        mp= new HashMap<>();
        return helper(n);
    }
    public int helper(int n){
        if(n<=3) return n;
        if(mp.containsKey(n)) return mp.get(n);
        int result=helper(n-1)+helper(n-2);
        mp.put(n,result);
        return mp.get(n);
    }
}