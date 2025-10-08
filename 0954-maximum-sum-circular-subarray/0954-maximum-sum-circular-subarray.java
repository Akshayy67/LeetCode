    class Solution {
        public int maxSubarraySumCircular(int[] nums) {
            int max=nums[0],min=nums[0],min_sum=0,max_sum=0,total=0;
            for(int num:nums){
                if(max_sum<0) max_sum=0;
                if(min_sum>0) min_sum=0;
                max_sum+=num;
                min_sum+=num;
                max=Math.max(max,max_sum);
                min=Math.min(min,min_sum);
                total+=num;
            }
            if(min==total) return max;
            return Math.max(max,total-min);
        }
    }