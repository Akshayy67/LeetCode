class Solution {
    int[] in,out,sums;
    public int minimumScore(int[] nums, int[][] edges) {
        Map<Integer,Set<Integer>> mp= new HashMap<>();
        int total=0,result=Integer.MAX_VALUE,n=nums.length;
        in= new int[n];
        out=new int[n];
        sums= new int[n];
        for(int i=0;i<nums.length;i++){
            mp.putIfAbsent(i, new HashSet<>());
            total^=nums[i];
        }
        for(int[] edge:edges){
            mp.get(edge[0]).add(edge[1]);
            mp.get(edge[1]).add(edge[0]);
        }
        dfs(0,-1,new int[] {0},mp,nums);
        for(int i=1;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(in[i]<in[j] && in[j]<out[i]){
                    int xor1=total^sums[i];
                    int xor2=sums[i]^sums[j];
                    int xor3=sums[j];
                    int min=Math.min(xor1,Math.min(xor2,xor3));
                    int max=Math.max(xor1,Math.max(xor2,xor3));
                    result=Math.min(result,max-min);
                }
                else if(in[j]<in[i] && in[i]<out[j]){
                    int xor1=total^sums[j];
                    int xor2=sums[i]^sums[j];
                    int xor3=sums[i];
                    int min=Math.min(xor1,Math.min(xor2,xor3));
                    int max=Math.max(xor1,Math.max(xor2,xor3));
                    result=Math.min(result,max-min);
                }
                else{
                    int xor1=sums[i];
                    int xor2=sums[j];
                    int xor3=sums[i]^sums[j]^total;
                    int min=Math.min(xor1,Math.min(xor2,xor3));
                    int max=Math.max(xor1,Math.max(xor2,xor3));
                    result=Math.min(result,max-min);
                }
            }
        }
        return result;
    }
    public void dfs(int root,int parent,int[] count,Map<Integer,Set<Integer>> mp,int[] nums){
        in[root]=count[0]++;
        sums[root]=nums[root];
        for(int neighbour:mp.get(root)){
            if(neighbour!=parent){
                dfs(neighbour,root,count,mp,nums);
                sums[root]^=sums[neighbour];
            }
        }
        out[root]=count[0];
        // return sums[root];
    }
}