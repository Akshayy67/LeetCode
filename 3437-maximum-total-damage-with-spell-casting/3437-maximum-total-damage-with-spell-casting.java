class Solution {
    public long maximumTotalDamage(int[] power) {
        TreeMap<Integer,Integer> mp= new TreeMap<>();
        for(int num:power) mp.put(num,mp.getOrDefault(num,0)+1);
        List<Integer> list= new ArrayList<>();
        mp.put(-10,0);
        for(int key:mp.keySet()) list.add(key);
        long max=0;
        long[] dp= new long[mp.size()];
        int j=1;
        // System.out.println(mp.size()+" "+list.size());
        for(int i=1;i<list.size();i++){
            while(j<i && list.get(j)<list.get(i)-2){
                max=Math.max(max,dp[j]);
                j++;
            }
            dp[i]=Math.max(max+(long)list.get(i)*mp.get(list.get(i)),dp[i-1]);
        }
        return dp[dp.length-1];
    }
}