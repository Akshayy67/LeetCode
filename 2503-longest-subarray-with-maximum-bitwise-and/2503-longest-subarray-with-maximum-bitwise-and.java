class Solution {
    public int longestSubarray(int[] nums) {
       int max=0;
       for(int num:nums) max=Math.max(max,num);
       int count=0,result=0;
       for(int num:nums){
        if(num==max){
            count++;
        }
        else{
            count=0;
        }
            result=Math.max(result,count);
       }
    //    result=Math.max(result,count)
       return result;
    }
}