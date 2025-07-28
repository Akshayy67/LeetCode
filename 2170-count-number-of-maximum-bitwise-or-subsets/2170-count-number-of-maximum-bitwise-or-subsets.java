class Solution {
    Map<Integer,Integer> mp;
    int mx;
    public int countMaxOrSubsets(int[] nums) {
        mp= new HashMap<>();
        mx=0;
        for(int num:nums)mx|=num;
        return helper(nums,0,0);
    }
    public int helper(int[] nums,int i ,int or){
        if(i==nums.length){
            return mx==or?1:0;
        }
        if(or==mx) return (1<<(nums.length-i));
        return helper(nums,i+1,or) + helper(nums,i+1,or|nums[i]);
    }
}