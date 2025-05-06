class Solution {
    public int minOperations(int[] nums) {
        int count=0,cur=nums[0];
        for(int i=1;i<nums.length;i++){
            if(cur>=nums[i]){
                int dif=cur-nums[i]+1;
                count+=dif;
                cur+=1;
            }
            else cur=nums[i];
        }
        return count;
    }
}