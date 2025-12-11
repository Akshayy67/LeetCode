class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        Map<Integer,TreeSet<Integer>> rows= new HashMap<>();
        Map<Integer,TreeSet<Integer>> cols= new HashMap<>();
        for(int[] building:buildings){
            int row=building[0];
            int col=building[1];
            rows.putIfAbsent(row,new TreeSet<>());
            cols.putIfAbsent(col,new TreeSet<>());
            rows.get(row).add(col);
            cols.get(col).add(row);
        }
        int result=0;
        for(int[] building:buildings){
            int row=building[0];
            int col=building[1];
            if(rows.get(row).higher(col)!=null && rows.get(row).lower(col)!=null && cols.get(col).higher(row)!=null && cols.get(col).lower(row)!=null)
            result++;
        }
        return result;
    }
}