class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int[] difference= new int[nums.length+1];
        for(int[] q:queries){
            difference[q[0]]++;
            difference[q[1]+1]--;
        }
        for(int i=1;i<nums.length;i++) difference[i]+=difference[i-1];
        for(int i=0;i<nums.length;i++){
            if(nums[i]>difference[i]) return false;
        }
        return true;
    }
}