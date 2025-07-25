class Solution {
    public int maxSum(int[] nums) {
        Set<Integer> st= new HashSet<>();
        int result=0;
        int max=Integer.MIN_VALUE;
        for(int num:nums){
            if(!st.contains(num) && num>=0){
                result+=num;
            }
            max=Math.max(max,num);
            st.add(num);
        }
        return max>=0?result:max;
    }
}