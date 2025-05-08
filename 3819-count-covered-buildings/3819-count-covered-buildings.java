class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        if(buildings.length<=4) return 0;
        Map<Integer,TreeSet<Integer>> rows= new HashMap<>();
        Map<Integer,TreeSet<Integer>> cols= new HashMap<>();
        for(int[] building:buildings){
            rows.putIfAbsent(building[0],new TreeSet<>());
            cols.putIfAbsent(building[1],new TreeSet<>());
            rows.get(building[0]).add(building[1]);
            cols.get(building[1]).add(building[0]);
        }
        int count=0;
        for(int[] building:buildings){
            if(possible(n,building,rows,cols)) count++;
        }
        return count;
    }
    public boolean possible(int n,int[] building,Map<Integer,TreeSet<Integer>> rows,Map<Integer,TreeSet<Integer>> cols){
        // int count=0;
        // for(int i=0;i<building[0];i++) {
        //     if(rows.containsKey(i) && rows.get(i).contains(building[1])){
        //         count++;
        //         break;
        //     }
        // }
        // for(int i=building[0]+1;i<n;i++) {
        //     if(rows.containsKey(i) && rows.get(i).contains(building[1])){
        //         count++;
        //         break;
        //     }
        // }
        // for(int i=0;i<building[1];i++) {
        //     if(cols.containsKey(i) && cols.get(i).contains(building[0])){
        //         count++;
        //         break;
        //     }
        // }
        // for(int i=building[1]+1;i<n;i++) {
        //     if(cols.containsKey(i) && cols.get(i).contains(building[0])){
        //         count++;
        //         break;
        //     }
        // }
        // return count==4;
        int r=building[0],c=building[1];
        if(rows.get(r).lower(c)==null) return false;
        if(rows.get(r).higher(c)==null) return false;
        if(cols.get(c).lower(r)==null) return false;
        if(cols.get(c).higher(r)==null) return false;
        return true;
    }
}