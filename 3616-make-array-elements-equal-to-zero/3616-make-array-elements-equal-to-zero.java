class Solution {
    public int countValidSelections(int[] nums) {
        int sum=0,count=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(nums[i]==0){
                int sum2=0;
                for(int j=i;j<nums.length;j++){
                    sum2+=nums[j];
                }
                if(sum==sum2) count+=2;
                else if(Math.abs(sum-sum2)==1) count+=1;
            }
        }
        return count;
    }
}