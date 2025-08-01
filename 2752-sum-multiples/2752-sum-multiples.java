class Solution {
    public int sumOfMultiples(int n) {
        Set<Integer> st= new HashSet<>();
        int num=3;
        while(num<=n){
            st.add(num);
            num+=3;
        }
        num=5;
        while(num<=n){
            st.add(num);
            num+=5;
        }
        num=7;
        while(num<=n){
            st.add(num);
            num+=7;
        }
        int sum=0;
        for(int number:st) sum+=number;
        return sum;
    }
}