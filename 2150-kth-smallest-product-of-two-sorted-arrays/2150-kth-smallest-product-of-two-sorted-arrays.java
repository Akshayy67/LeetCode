class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long low=-10000000000L,high=100000000000L,mid=0;
        while(low<high){
            mid=low+(high-low)/2;
            if(countLess(nums1,nums2,mid)<k){
                low=mid+1;
            }
            else{
                high=mid;
            }
        }
        return low;
    }
    public long countLess(int[] nums1,int[] nums2,long target){
        long count=0;
        for(int num:nums1){
            if(num==0) {
                if(target>=0)count+=nums2.length;
                continue;
            }
            int low=0,high=nums2.length,mid=0;
            if(num>0){
                while(low<high){
                    mid=(high-low)/2+low;
                    if((long)nums2[mid]*num<=target){
                        low=mid+1;
                    }
                    else high=mid;
                }
                count+=low;
            }
            else{
                while(low<high){
                    mid=(low+high)/2;
                    if((long)num*nums2[mid]<=target){
                        high=mid;
                    }
                    else low=mid+1;
                }
                count+=nums2.length-low;
            }
        }
        return count; 
    }
}