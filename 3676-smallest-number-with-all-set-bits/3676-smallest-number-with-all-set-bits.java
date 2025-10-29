class Solution {
    public int smallestNumber(int n) {
        int result=0;
        while(n>0){
            result<<=1;
            result|=1;
            n>>=1;
        }
        return result;
    }
}