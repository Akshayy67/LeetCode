class Solution {
    Map<Integer,Integer> mp;
    public int countMaxOrSubsets(int[] nums) {
        mp= new HashMap<>();
        helper(nums,0,0);
        int max=Collections.max(mp.keySet());
        return mp.get(max);
    }
    public void helper(int[] nums,int i ,int or){
        if(i==nums.length){
            mp.put(or,mp.getOrDefault(or,0)+1);
            return;
        }
        helper(nums,i+1,or);
        helper(nums,i+1,or|nums[i]);
    }
}