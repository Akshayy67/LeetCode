class Solution {
    public boolean findSubarrays(int[] nums) {
        Set<Integer> st= new HashSet<>();
        for(int i=0;i<nums.length-1;i++){
            int sum=nums[i]+nums[i+1];
            if(st.contains(sum)) return true;
            st.add(sum);
        }
        return false;
    }
}