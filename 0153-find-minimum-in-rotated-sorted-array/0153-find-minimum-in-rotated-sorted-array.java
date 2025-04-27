class Solution {
    public int findMin(int[] nums) {
        int l=0,r=nums.length-1,mid=0;
        int ans=0;
        while(l<r){
             mid=(l+r)/2;
            // eleminate the left part as it is sorted minimum is compuslorily on right half
            if(nums[r]<nums[mid]) l=mid+1; 
            //eliminate right part
            else r=mid;
        }
        return nums[l];
    }
}