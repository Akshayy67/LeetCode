class Solution {
    public int findPeakElement(int[] nums) {
        int low=0,high=nums.length-1,mid=0;
        while(low<=high){
            mid=(low+high)/2;
            int prev=(mid==0)?Integer.MIN_VALUE:nums[mid-1];
            int next=(mid==nums.length-1)?Integer.MIN_VALUE:nums[mid+1];
            if(nums[mid]>prev && nums[mid]>next) return mid;
            if(nums[mid]<next) low=mid+1;
            else high=mid-1;
        }
        return 0;
    }
}