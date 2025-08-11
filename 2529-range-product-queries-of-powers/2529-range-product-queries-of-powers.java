class Solution {
    int mod=(int) 1e9+7;
    public int[] productQueries(int n, int[][] queries) {
        int[] result= new int[queries.length];
        List<Long> list= new ArrayList<>();
        for(int i=0;i<32;i++){
            if(((n>>i)&1)==1) list.add(1L<<i);
        }
        for(int q=0;q<queries.length;q++){
            int[] query= queries[q];
            long ans=1;
            for(int i=query[0];i<=query[1];i++){
                ans=(ans*(list.get(i)%mod))%mod;
            }
            result[q]=(int)ans;
        }
        return result;
    }
}