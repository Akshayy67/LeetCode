class Solution {
    public int countTriples(int n) {
        int result=0;
        for(int i=1;i<=n;i++){
            for(int j=i+1;j<=n;j++){
                int num=i*i+j*j;
                int sqrt=(int)Math.sqrt(num);
                if(sqrt*sqrt==num && sqrt<=n) result+=2;
            }
        }
        return result;
    }
}