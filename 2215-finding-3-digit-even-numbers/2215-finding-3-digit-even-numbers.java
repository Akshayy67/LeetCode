class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> st= new TreeSet<>();
        int n=digits.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    if(i!=j && j!=k && i!=k && digits[k]%2==0 && digits[i]!=0){
                        st.add(digits[i]*100 + digits[j]*10 + digits[k]);
                    }
                }
            }
        }
        int[] result= new int[st.size()];
        int i=0;
        for(int num:st) result[i++]=num;
        return result;
    }
}