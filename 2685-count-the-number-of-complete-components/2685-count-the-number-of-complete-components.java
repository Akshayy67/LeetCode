class DSU{
    int[] parents;
    int[] sizes;
    int n;
    public DSU(int n){
        this.n= n;
        parents= new int[n];
        sizes= new int[n];
        for(int i=0;i<n;i++){
            parents[i]=i;
            sizes[i]=1;
        }
    }
    public int findParent(int node){
        if(parents[node]==node) return node;
        return parents[node]=findParent(parents[node]);
    }
    public void merge(int v,int u){
        int up=findParent(u);
        int vp=findParent(v);
        if(vp==up) return;
        parents[vp]=up;
        sizes[up]+=sizes[vp];
    }

}
class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        int[] counts= new int[n];
        Arrays.fill(counts,1);
        DSU dsu= new DSU(n);
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            counts[u]++;
            counts[v]++;
            dsu.merge(u,v);
        }
        int result=0;
        Set<Integer> st= new HashSet<>();
        for(int i=0;i<n;i++){
            if(i==dsu.findParent(i)) st.add(i);
        }
        for(int i=0;i<n;i++){
            int parent= dsu.findParent(i);
            if(counts[i]!=dsu.sizes[parent]) st.remove(parent);
        }
        return st.size();
    }
}