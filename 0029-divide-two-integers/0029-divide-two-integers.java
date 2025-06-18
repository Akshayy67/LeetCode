class Solution {
    public int divide(int dividend, int divisor) {
       boolean neg=false;
        if((dividend>=0 && divisor<0) || (dividend<0 && divisor>0)) neg=true;
        long div = Math.abs((long) dividend);
        long dsr = Math.abs((long) divisor);
        long ans=0;
        while(div>=dsr){
            long count=0;
            while(div>=(dsr<<(count+1))){
                count++;
            }
            ans+=(1L<<(count));
            div-=(dsr<<(count));
        }
        if(neg) ans*=-1;
        if(ans>Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(ans<Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int)ans;
    }
}