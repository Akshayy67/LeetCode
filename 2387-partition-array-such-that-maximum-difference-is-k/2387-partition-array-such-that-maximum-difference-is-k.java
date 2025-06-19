class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int result=1,last=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]-nums[last]>k){
                last=i;
                result++;
            }
        }
        return result;
    }
}