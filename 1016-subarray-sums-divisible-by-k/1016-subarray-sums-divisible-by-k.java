class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int result=0;
        Map<Integer,Integer> mp= new HashMap<>();
        mp.put(0,1);
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int mod=(sum%k+k)%k;
            result+=mp.getOrDefault(mod,0);
            mp.put(mod,mp.getOrDefault(mod,0)+1);
        }
        return result;
    }
}