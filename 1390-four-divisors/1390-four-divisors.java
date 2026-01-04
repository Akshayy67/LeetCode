class Solution {
    public int sumFourDivisors(int[] nums) {
        int result=0;
        for(int num:nums){
            Set<Integer> st= new HashSet<>();
            boolean flag=true;
            for(int i=1;i<=Math.sqrt(num);i++){
                if(num%i==0) {
                    st.add(i);
                    st.add(num/i);
                }
                if(st.size()>4){
                    flag=false;
                    break;
                }
            }
            if(flag && st.size()==4){
                for(int temp:st) result+=temp;
            }
        }
        return result;
    }
}