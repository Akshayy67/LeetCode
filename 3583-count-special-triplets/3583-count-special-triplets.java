class Solution {
    int mod=(int) 1e9+7;
    public int specialTriplets(int[] nums) {
        Map<Integer,Integer> prev = new HashMap<>();
        Map<Integer,Integer> next = new HashMap<>();
        for(int num:nums){
           next.put(num,next.getOrDefault(num,0)+1);
        }
        int result=0;
        for(int num:nums){
            next.put(num,next.get(num)-1);
            long count=((long)prev.getOrDefault(num*2,0)*next.getOrDefault(num*2,0))%mod;
            result=(result+(int)count)%mod;
            prev.put(num,prev.getOrDefault(num,0)+1);
        }
        return result;
    }
}