class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length;
        int[] result= new int[n];
        int e=0,o=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0) {
                result[e]=nums[i];
                e+=2;
            }
            else{
                result[o]=nums[i];
                o=o+2;
            } 
        }
        return result;
    }
}