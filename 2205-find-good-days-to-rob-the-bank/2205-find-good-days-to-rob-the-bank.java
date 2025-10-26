class Solution {
    public List<Integer> goodDaysToRobBank(int[] nums, int time) {
        int n = nums.length;
        int[] pre = new int[n];
        int[] post = new int[n];
        pre[0]=0;post[n-1]=0;
        for(int i=1;i<n;i++){
            if(nums[i]<=nums[i-1]) pre[i]=pre[i-1]+1;
            else pre[i]=0;
        }
        for(int i=n-2;i>=0;i--){
            if(nums[i]<=nums[i+1]) post[i]=post[i+1]+1;
            else post[i]=0;
        }
        List<Integer> result= new ArrayList<>();
        for(int i=0;i<n;i++){
            if(pre[i]>=time && post[i]>=time) result.add(i);
        }
        return result;
    }
}
