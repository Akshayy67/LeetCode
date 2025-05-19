class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> mp= new HashMap<>();
        mp.put(0,1);
        int result=0,sum=0;
        for(int num:nums){
            sum+=num;
            if(mp.containsKey(sum-k)) result+=mp.get(sum-k);
            mp.put(sum,mp.getOrDefault(sum,0)+1);
        }
        return result;
    }
}