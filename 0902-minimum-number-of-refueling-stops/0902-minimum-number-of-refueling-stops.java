class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->b[1]-a[1]);
        int result=0,j=0;
        while(startFuel<target){
            while(j<stations.length && startFuel>=stations[j][0]){
                pq.add(stations[j]);
                j++;
            }
            if(pq.isEmpty()) return -1;
            startFuel+=pq.poll()[1];
            result++;
        }
        return result;
    }
}