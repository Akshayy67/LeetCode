class Solution {
    public int[] singleNumber(int[] nums) {
        int xor=0;
        for(int num:nums){
            xor^=num;
        }
        int lastSet=xor&-xor;
        int yes=0,no=0;
        for(int num:nums){
            if((num&lastSet)!=0) yes^=num;
            else no^=num;
        }
        return new int[] {yes,no};
    }
}