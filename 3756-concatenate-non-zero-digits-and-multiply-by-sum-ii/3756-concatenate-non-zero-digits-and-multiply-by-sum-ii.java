class Solution {
    private static final int MAX_N = 100001;
    private static final long[] pow10 = new long[MAX_N];
    static long mod=(long) 1e9+7;

    // static runs only once for all test cases
    static {
        pow10[0] = 1;
        for (int i = 1; i < MAX_N; ++i) {
            pow10[i] = (pow10[i - 1] * 10) % mod;
        }
    }
    public int[] sumAndMultiply(String s, int[][] queries) {
        long[] nums= new long[s.length()];
        long[] sums= new long[s.length()];
        int[] counts= new int[s.length()];
        nums[0]=s.charAt(0)-'0';
        sums[0]=s.charAt(0)-'0';
        counts[0]=(s.charAt(0)=='0')?0:1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)=='0'){
                nums[i]=nums[i-1];
                sums[i]=sums[i-1];
                counts[i]=counts[i-1];
            }
            else{
                nums[i]=((nums[i-1]*10)+(s.charAt(i)-'0'))%mod;
                sums[i]=sums[i-1]+(s.charAt(i)-'0');
                counts[i]=counts[i-1]+1;
            }
        }
        int[] result= new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int[] q= queries[i];
            if(q[0]==0){
                long ans=(nums[q[1]]*sums[q[1]])%mod;
                result[i]=(int) ans;
            }
            else{
                long num=(nums[q[1]]-((nums[q[0]-1])*pow10[counts[q[1]]-counts[q[0]-1]])%mod+mod)%mod;
                long sum=sums[q[1]]-sums[q[0]-1];
                long ans=(num*sum)%mod;
                result[i]=(int)ans;
            }
        }
        return result;
    }
}