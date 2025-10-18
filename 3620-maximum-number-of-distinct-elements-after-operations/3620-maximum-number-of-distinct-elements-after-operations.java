class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int count=1,prev=nums[0]-k;
        for(int i=1;i<nums.length;i++){
            if(prev>=nums[i]+k) continue;
            count++;
            prev=Math.max(prev+1,nums[i]-k);
        }
        return count;
    }
}