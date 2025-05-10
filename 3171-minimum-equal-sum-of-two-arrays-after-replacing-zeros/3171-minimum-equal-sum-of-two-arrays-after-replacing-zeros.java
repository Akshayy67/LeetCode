class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1=0,sum2=0;
        int z1=0,z2=0;
        for(int num:nums1){
            if(num==0) z1++;
            sum1+=num;
        }
        for(int num:nums2){
            if(num==0) z2++;
            sum2+=num;
        }
        if(sum1==sum2){
            if(z1==0 && z2==0) return sum1;
            if(z1==0 || z2==0) return -1;
            else return sum1+Math.max(z1,z2);
        }
        else if(sum1>sum2){
            if(z2==0) return -1;
            if(z1==0 && sum2+z2>sum1) return -1;
            return Math.max(sum1+z1,sum2+z2);
        }
        else{
            if(z1==0 ) return -1;
            if(z2==0 && sum1+z1>sum2) return -1;
            return Math.max(sum1+z1,sum2+z2);
            //  return sum2+z2;
        }
    }
}