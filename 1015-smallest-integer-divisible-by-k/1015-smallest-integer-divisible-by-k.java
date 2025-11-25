class Solution {
    public int smallestRepunitDivByK(int k) {
        Set<Integer> st= new HashSet<>();
        int num=1;
        while(true){
            int remainder=num%k;
            if(remainder==0) return st.size()+1;
            if(st.contains(remainder)) return -1;
            st.add(remainder);
            num=remainder*10+1;
        }
        // return -1;
    }
}