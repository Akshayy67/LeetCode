class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int count=0;
        Set<Integer> st= new HashSet<>();
        for(int num:nums) st.add(num);
        int k=st.size();
        for(int i=0;i<nums.length;i++){
            st=new HashSet<>();
            for(int j=i;j<nums.length;j++){
                st.add(nums[j]);
                if(st.size()==k) count++;
                if(st.size()>k) break;
            }
        }
        return count;
    }
}