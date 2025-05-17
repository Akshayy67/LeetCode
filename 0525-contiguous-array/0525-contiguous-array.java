class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> mp= new HashMap<>();
        int count =0, max=0;
        mp.put(0,-1);
        for(int i=0;i<nums.length;i++){
            count+=(nums[i]==1)?1:-1;
            if(mp.containsKey(count)) max=Math.max(max,i-mp.get(count));
            else mp.put(count,i);
        }
        return max;
    }
}