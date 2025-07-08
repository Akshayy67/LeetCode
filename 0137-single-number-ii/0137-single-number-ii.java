class Solution {
    public int singleNumber(int[] nums) {
        int result=0;
        for(int i=0;i<32;i++){
            int cnt=0;
            for(int num:nums){
                cnt+=((num>>i)&1);
            }
            if(cnt%3!=0) result|=(1L<<i);
        }
        return result;
    }
}