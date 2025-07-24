class Solution {
    int result= Integer.MAX_VALUE;
    public int minimumScore(int[] nums, int[][] edges) {
        Map<Integer,Set<Integer>> mp= new HashMap<>();
        // int result=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++) mp.put(i,new HashSet<>());
        for(int[] edge:edges){
            mp.get(edge[0]).add(edge[1]);
            mp.get(edge[1]).add(edge[0]);
        }
        int total=0;
        for(int num:nums) total^=num;
        dfs(0,-1,nums,mp,total);
        return result;
    }
    public int dfs(int root,int parent,int[] nums,Map<Integer,Set<Integer>> mp,int total){
        int xor=nums[root];
        for(int neighbour:mp.get(root)){
            if(neighbour==parent) continue;
            xor^=dfs(neighbour,root,nums,mp,total);
        }
        for(int neighbour:mp.get(root)){
            if(neighbour==parent){
                dfs2(parent,root,root,xor,nums,mp,total);
            }
        }
        return xor;
    }
    public int dfs2(int root,int parent,int anc,int xor1,int[] nums,Map<Integer,Set<Integer>> mp,int total){
        int xor=nums[root];
        for(int neighbour:mp.get(root)){
            if(neighbour==parent) continue;
            xor^=dfs2(neighbour,root,anc,xor1,nums,mp,total);
        }
        if(parent==anc) return -1;
        int xor2=total^xor1^xor;
        int min=Math.min(xor1,Math.min(xor,xor2));   
        int max=Math.max(xor1,Math.max(xor,xor2));
        result=Math.min(result,max-min);
        return xor;   
    }
}