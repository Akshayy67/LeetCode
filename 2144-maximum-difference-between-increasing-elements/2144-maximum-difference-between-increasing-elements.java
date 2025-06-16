class Solution {
    public int maximumDifference(int[] nums) {
        int result=-1,min=nums[0];
        for(int i=1;i<nums.length;i++){
            int num=nums[i];
            if(num>min)
            result=Math.max(result,num-min);
            min=Math.min(min,num);
        }
        return result;
    }
}