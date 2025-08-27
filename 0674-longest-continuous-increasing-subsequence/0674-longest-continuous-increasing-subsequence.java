class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int result=0,count=1,prev=nums[0];
        for(int num:nums){
            if(num>prev){
                count++;
            }
            else{
                result=Math.max(result,count);
                count=1;
            }
            prev=num;
        }
        return Math.max(result,count);
    }
}