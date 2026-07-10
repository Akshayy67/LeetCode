class Solution {
    public long sumAndMultiply(int n) {
        long num=0,sum=0;
        int len=0;
        while(n>0){
            long rem=n%10;
            sum+=rem;
            num=rem*((long)Math.pow(10,len))+num;
            len+=(rem==0)?0:1;
            n=n/10;
        }
        return sum*num;
    }
}