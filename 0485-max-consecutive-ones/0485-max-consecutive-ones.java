class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max=0,cur=0;
        for(int num:nums){
            cur=(num==1)?1+cur:0;
            max=Math.max(max,cur);
        }
        return max;
    }
}