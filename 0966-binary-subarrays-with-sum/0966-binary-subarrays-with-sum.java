class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer,Integer> mp= new HashMap<>();
        mp.put(0,1);
        int sum=0,result=0;
        for(int num:nums){
            sum+=num;
            result+=mp.getOrDefault(sum-goal,0);
            mp.put(sum-goal,mp.getOrDefault(sum,0)+1);
        }
        return result;
    }
}