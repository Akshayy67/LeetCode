class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int max=Arrays.stream(nums).max().getAsInt();
        max++;
        int[] count=new int[max+1];
        for(int num:nums) count[num]++;
        int total=0;
        for(int i=0;i<Math.min(k,max);i++){
            total+=count[i];
        }
        int result=0;
        for(int i=0;i<max;i++){
            if(i+k<max) total+=count[i+k];
            result=Math.max(result,count[i]+Math.min(numOperations,total-count[i]));
            if(i-k>=0) total-=count[i-k];
        }
        return result;
    }
}