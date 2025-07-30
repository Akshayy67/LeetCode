class Solution {
    public int longestSubarray(int[] nums) {
       int max=0;
       int count=0,result=0;
       for(int num:nums){
            if(max<num){
                count=result=0;
                max=num;
            }
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