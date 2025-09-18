class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indeg= new int[numCourses];
        Map<Integer,List<Integer>> mp= new HashMap<>();
        for(int i=0;i<numCourses;i++) mp.put(i, new ArrayList<>());
        for(int[] pre:prerequisites){
            int u=pre[0];
            int v=pre[1];
            mp.get(u).add(v);
            indeg[v]++;
        }
        Queue<Integer> q= new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indeg[i]==0) q.add(i);
        }
        while(!q.isEmpty()){
            int cur=q.poll();
            for(int v:mp.get(cur)){
                indeg[v]--;
                if(indeg[v]==0) q.add(v);
            }
        }
        for(int i=0;i<numCourses;i++){
            if(indeg[i]>0) return false;
        }
        return true;
        
    }
}