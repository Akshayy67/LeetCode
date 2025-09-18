class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> mp= new HashMap<>();
        int[] indeg=  new int[numCourses];
        for(int i=0;i<numCourses;i++) mp.put(i, new ArrayList<>());
        for(int pre[] : prerequisites){
            int u=pre[0];
            int v=pre[1];
            mp.get(v).add(u);
            indeg[u]++;
        }
        int[] order= new int[numCourses];
        int x=0;
        Queue<Integer> q= new LinkedList<>();
        for(int i=0;i<numCourses;i++) {
            if(indeg[i]==0){
                q.add(i);
                order[x++]=i;
            } 
        }
        while(!q.isEmpty()){
            int cur=q.poll();
            for(int v:mp.get(cur)){
                indeg[v]--;
                if(indeg[v]==0){
                    q.add(v);
                    order[x++]=v;
                }
            }
        }
        if(x<numCourses-1) return new int[] {};
        return order;
    }
}