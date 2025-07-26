class Solution {
    public long maxSubarrays(int n, int[][] conflictingPairs) {
        int top1=0,top2=0;
        long valid=0,max=0;
        List<Integer>[] list= new ArrayList[n+1];
        long[] gains= new long[n+1];
        for(int i=0;i<=n;i++) list[i]=new ArrayList<>();
        for(int[] pair:conflictingPairs){
            int a=Math.min(pair[0],pair[1]);
            int b=Math.max(pair[0],pair[1]);
            list[b].add(a);
        }
        for(int i=1;i<=n;i++){
            for(int left:list[i]){
                if(left>top1){
                    top2=top1;
                    top1=left;
                }
                else if(top2<left) top2=left;
            }
            valid+=i-top1;
            gains[(int)top1]+=top1-top2;
            max=Math.max(max,gains[(int)top1]);
        }
        return valid+max;
    }
}