class Pair{
    String v;
    double val;
    public Pair(String v,double val){
        this.v=v;
        this.val=val;
    }
}
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String,List<Pair>> mp= new HashMap<>();
        for(int i=0;i<equations.size();i++){
            List<String> e=equations.get(i);
            String u=e.get(0);
            String v=e.get(1);
            mp.putIfAbsent(u, new ArrayList<>());
            mp.putIfAbsent(v, new ArrayList<>());
            mp.get(u).add(new Pair(v,values[i]));
            mp.get(v).add(new Pair(u,1.0/values[i]));
        }
        double[] result= new double[queries.size()];
        for(int i=0;i<queries.size();i++){
            String u=queries.get(i).get(0);
            String v=queries.get(i).get(1);
            if(!mp.containsKey(u) || !mp.containsKey(v)){
                result[i]=-1;
                continue;
            }
            if(u.equals(v)){
                result[i]=1;
                continue;
            }
            double ans=1;
            Queue<Pair> q= new LinkedList<>();
            Set<String> st= new HashSet<>();
            q.add(new Pair(u,1.0));
            st.add(u);
            while(!q.isEmpty()){
                Pair cur=q.poll();
                for(Pair neighbor:mp.get(cur.v)){
                    if(st.contains(neighbor.v)) continue;
                    double newVal=cur.val*neighbor.val;
                    if(v.equals(neighbor.v)){
                        result[i]=newVal;
                        q.clear();
                        break;
                    }
                    st.add(neighbor.v);
                    q.add(new Pair(neighbor.v,newVal));
                }
            }
        }
        return result;
    }
}