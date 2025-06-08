class Solution {
    public int numTriplets(int[] nums1, int[] nums2) {
        int result=0;
        Map<Long,Integer> mp= new HashMap<>();
        for(int num:nums1){
            long sqr=(long)Math.pow(num,2);
            mp.put(sqr,mp.getOrDefault(sqr,0)+1);
        }
        for(int i=0;i<nums2.length;i++){
            for(int j=i+1;j<nums2.length;j++){
                long mul= (long)nums2[i]*nums2[j];
                result+=mp.getOrDefault(mul,0);
            }
        }
        mp.clear();
        for(int num:nums2){
            long sqr=(long)Math.pow(num,2);
            mp.put(sqr,mp.getOrDefault(sqr,0)+1);
        }
        for(int i=0;i<nums1.length;i++){
            for(int j=i+1;j<nums1.length;j++){
                long mul= (long)nums1[i]*nums1[j];
                result+=mp.getOrDefault(mul,0);
            }
        }
        return result;
    }
}