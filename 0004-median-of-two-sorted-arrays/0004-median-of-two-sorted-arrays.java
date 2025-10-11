class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total=(nums1.length+nums2.length);
        int mid=(total)/2;
        int prev=0,cur=0;
        int i=0,j=0;
        for(int k=0;k<=mid;k++){
            prev=cur;
            if(i<nums1.length && (j>=nums2.length || nums1[i]<=nums2[j])){
                cur=nums1[i++];
            }
            else cur=nums2[j++];
        }
        if((total&1)==1) return cur;
        return (cur+prev)/2.0;
    }
}