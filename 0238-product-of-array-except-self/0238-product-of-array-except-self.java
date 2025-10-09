class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] post=new int[nums.length];
        post[nums.length-1]=nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            post[i]=post[i+1]*nums[i];
        }
        int[] result= new int[nums.length];
        int pre=1;
        for(int i=0;i<nums.length;i++){
            int next=(i==nums.length-1)?1:post[i+1];
            result[i]=pre*next;
            pre=pre*nums[i];
        }
        return result;
    }
}