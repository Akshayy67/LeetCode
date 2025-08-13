class Solution {
    public boolean isPowerOfThree(int n) {
        while(n>=3 && n%3==0){
            n=n/3;
        }
        return n==1;
    }
}