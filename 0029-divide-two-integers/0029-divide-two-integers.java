class Solution {
    public int divide(int dividend, int divisor) {
        boolean neg=((dividend<0)^(divisor<0));
        // System.out.println(neg);
        long dvd=Math.abs((long)dividend);
        long div=Math.abs((long)divisor);
        long ans=0;
        while(dvd>=div){
            int count=0;
            while(dvd>=(div<<count)){
                count++;
            }
            count--;
            ans+=(1L<<count);
            dvd-=(div<<count);
        }
        ans=ans*(neg?-1:1);
        if(ans>=Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(ans<=Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int)ans;
    }
}