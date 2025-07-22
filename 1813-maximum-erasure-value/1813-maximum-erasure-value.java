class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int[] lastIdx= new int[10001];
        Arrays.fill(lastIdx,-1);
        int[] prefix= new int[nums.length+1];
        int l=-1,result=0;
        for(int i=0;i<nums.length;i++){
            prefix[i+1]=prefix[i]+nums[i];
            if(lastIdx[nums[i]]!=-1){
                l=Math.max(l,lastIdx[nums[i]]);
            }
            result=Math.max(result,prefix[i+1]-prefix[l+1]);
            lastIdx[nums[i]]=i;
        }
        return result;
    }
}