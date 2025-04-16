class Solution {
    public int pivotIndex(int[] nums) {
      int idx=-1,sum=0,cur=0;
      for(int num:nums) sum+=num;
      for(int i=0;i<nums.length;i++){
        sum-=nums[i];
        if(cur==sum) return i;
        cur+=nums[i];
      }  
      return -1;
    }
}