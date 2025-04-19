class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        int n=nums.length;
        long result=0;
        for(int i=0;i<nums.length;i++){
            long low=loe(nums,i+1,n-1,lower-nums[i]);
            long high=goe(nums,i+1,n-1,upper-nums[i]);
            result+=(high-low+1);
        }
        return result;
    }
    public int loe(int[] nums,int left,int right,int target){
        int result=right+1;
        while(left<=right){
            int mid=(right-left)/2 + left;
            if(nums[mid]>=target){
                result=mid;
                right=mid-1;
            }
            else left=mid+1;
        }
        return result;
    }
    public int goe(int[] nums,int left, int right,int target){
        int result=left-1;
        while(left<=right){
            int mid=(right-left)/2+left;
            if(nums[mid]<=target){
                left=mid+1;
                result=mid;
            }
            else right=mid-1;
        }
        return result;
    }
}