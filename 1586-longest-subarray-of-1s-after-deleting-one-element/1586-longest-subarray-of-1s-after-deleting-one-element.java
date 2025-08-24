class Solution {
    public int longestSubarray(int[] nums) {
        int zero=0;
        int max=0,j=0;
        for(int i=0;i<nums.length;i++){
            zero+=(nums[i]==0?1:0);
            while(zero==2){
                zero-=(nums[j]==0?1:0);
                j++;
            }
            max=Math.max(max,i-j);
        }
        return max;
    }
}