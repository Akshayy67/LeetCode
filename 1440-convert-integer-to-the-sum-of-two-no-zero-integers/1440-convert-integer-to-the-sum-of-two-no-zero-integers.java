class Solution {
    public int[] getNoZeroIntegers(int n) {
        for(int i=1;i<=n;i++){
            if(noZero(i) && noZero(n-i)) return new int[] {i,n-i};
        }
        return new int[] {1,1};
    }
    public boolean noZero(int n){
        while(n>0){
            if(n%10==0) return false;
            n/=10;
        }
        return true;
    }
}