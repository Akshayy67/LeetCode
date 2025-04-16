class Solution {
    public int longestSubarray(int[] nums) {
        int flag=0,max=0,count=0;
        int i=0,j=0;
        for(i=0;i<nums.length;i++){
            count++;
            if(nums[i]==0) flag++;
            while(flag==2){
                count--;
                if(nums[j]==0) flag--;
                j++;
            }
            max=Math.max(max,count);
        }
        return max-1;
    }
}