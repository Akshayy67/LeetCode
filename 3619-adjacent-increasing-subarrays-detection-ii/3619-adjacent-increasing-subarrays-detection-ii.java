class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int pre=0,cur=0;
        int ans=0;
        for(int i=0;i<nums.size();i++){
            cur++;
            if(i==nums.size()-1 || nums.get(i)>=nums.get(i+1)){
                ans=Math.max(ans,Math.max(cur/2,Math.min(pre,cur)));
                pre=cur;
                cur=0;
            }
        }
        return ans;
    }
}