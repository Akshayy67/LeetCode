class Solution {
    public int findMin(int[] nums) {
        int l=0,r=nums.length-1,mid=0;
        int ans=0;
        while(l<r){
             mid=(l+r)/2;
            if(nums[l]>nums[mid]){
                r=mid;
            }
            else if(nums[r]<nums[mid]){
                l=mid+1;
            }
            else{
                r--;
            }
        }
        return nums[l];
    }
}