class Pair{
    int x,y;
    public Pair(int x,int y){
        this.x=x;
        this.y=y;
    }
    public boolean equals(Object o){
        if(this==o) return true;
        Pair p=  (Pair) o;
        return x==p.x && y==p.y;
    }
    public int hashCode(){
        return Objects.hash(x,y);
    }
}
class Solution {
    public boolean canMeasureWater(int x, int y, int target) {
        Queue<Pair> q= new LinkedList<>();
        q.add(new Pair(x,y));
        Set<Pair> st= new HashSet<>();
        st.add(new Pair(0,0));
        while(!q.isEmpty()){
            Pair cur=q.poll();
            int a=cur.x,b=cur.y;
            if(a+b==target) return true;
            List<Pair> pairs=Arrays.asList(
            new Pair(0,b),
            new Pair(a,0),
            new Pair(a,y),
            new Pair(x,b),
            new Pair(a-Math.min(a,y-b),Math.min(y,b+a)),
            new Pair(Math.min(a+b,x),b-Math.min(b,x-a))
            );
            for(Pair p:pairs){
                if(st.contains(p)) continue;
                st.add(p);
                q.add(p);
            }
        }
        return false;
    }
}