class Solution {
    public int maxProduct(int[] nums) {
        int result=nums[0];
        int lprod=1,rprod=1;
        for(int i=0;i<nums.length;i++){
            lprod=(lprod==0)?1:lprod;
            rprod=(rprod==0)?1:rprod;
            lprod*=nums[i];
            rprod*=nums[nums.length-1-i];
            result=Math.max(result,Math.max(lprod,rprod));
        }
        return result;
    }
}