class Solution {
    public void nextPermutation(int[] nums) {
        int i=nums.length-2;
        while(i>=0 && nums[i]>=nums[i+1]) i--;
        if(i==-1){
            reverse(nums,0,nums.length-1);
            return;
        }
        int j=nums.length-1;
        // for(int j=i+1;j<nums.length;j++){
            while(j>i && nums[j]<=nums[i]){
                j--;
            }
            
        // }
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
        reverse(nums,i+1,nums.length-1);
    }
    public void reverse(int[] nums,int i,int j){
        while(i<j){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;j--;
        }
    }
}