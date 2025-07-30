class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> result= new HashSet<>();
        Set<Integer> prev= new HashSet<>();
        for(int num:arr){
            Set<Integer> st= new HashSet<>();
            st.add(num);
            for(int n:prev){
                st.add(num|n);
            }
            result.addAll(st);
            prev=st;
        }
        return result.size();
    }
}