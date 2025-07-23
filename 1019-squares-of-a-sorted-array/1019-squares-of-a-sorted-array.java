class Solution {
    public int[] sortedSquares(int[] nums) {
        int i=0,j=nums.length-1,k=nums.length-1;
        int[] result= new int[nums.length];
        while(k>=0){
            int l=nums[i]*nums[i];
            int r=nums[j]*nums[j];
            if(l>r){
                result[k]=l;
                i++;
            }
            else{
                result[k]=r;
                j--;
            }
            k--;
        }
        return result;
    }
}