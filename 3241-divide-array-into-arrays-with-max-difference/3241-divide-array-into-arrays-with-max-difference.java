class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int[][] result= new int[nums.length/3][3];
        int i=0;
        while(i<nums.length){
            for(int j=i;j<i+3;j++){
                result[i/3][j-i]=nums[j];
            }
            if(nums[i+2]-nums[i]>k) return new int[][] {};
            i+=3;
        }
        return result;
    }
}