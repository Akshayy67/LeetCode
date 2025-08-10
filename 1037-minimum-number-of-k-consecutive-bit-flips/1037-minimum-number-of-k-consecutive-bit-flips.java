class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int n=nums.length;
        int[] flips= new int[n+1];
        int cur=0,ans=0;
        for(int i=0;i<nums.length;i++){
            int num=nums[i];
            cur-=flips[i];
            if(cur>0 && cur%2==1) num=num^1;
            if(num==0){
                if(i+k>n) return -1;
                cur++;
                ans++;
                flips[i+k]++;
            }
        }
        return ans;
    }
}