class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> result=new ArrayList<>();
        int n=graph.length;
        int[] outdeg=new int[n];
        Queue<Integer> q= new LinkedList<>();
        Map<Integer,List<Integer>> mp= new HashMap<>();
        for(int i=0;i<n;i++){
            mp.putIfAbsent(i,new ArrayList<>());
            for(int v:graph[i]){
                mp.putIfAbsent(v, new ArrayList<>());
                mp.get(v).add(i);
            }
            outdeg[i]=graph[i].length;
            if(outdeg[i]==0) q.add(i);
        }
        while(!q.isEmpty()){
            int cur=q.poll();
            result.add(cur);
            for(int neighbour:mp.get(cur)){
                outdeg[neighbour]--;
                if(outdeg[neighbour]==0) q.add(neighbour);
            }
        }
        Collections.sort(result);
        return result;

    }
}