class Solution {
    public int findNumbers(int[] nums) {
        int result=0;
        StringBuilder str=new StringBuilder();
        for(int num:nums){
            str.append(num);
            if(str.length()%2==0) result++;
            str.setLength(0);
        }
        return result;
    }
}