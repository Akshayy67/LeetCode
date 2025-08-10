class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
       int low=1,high=1,mid=0;
       for(int num:nums) high=Math.max(num,high);
       while(low<=high){
            mid=(high+low)/2;
            if(possible(nums,mid,threshold)) high=mid-1;
            else low=mid+1;
       } 
       return low;
    }
    public boolean possible(int[] nums,int divisor,int threshold){
        int cur=0;
        for(int num:nums){
            cur+=Math.ceil((double)num/divisor);
        }
        return cur<=threshold;
    }
}