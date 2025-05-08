class Solution {
    int[][] directions={{-1,0},{0,1},{1,0},{0,-1}};
    public int minTimeToReach(int[][] moveTime) {
        int n=moveTime.length,m=moveTime[0].length;
        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->a[2]-b[2]);
        boolean[][] visited= new boolean[n][m];
        pq.add(new int[] {0,0,0,0});
        visited[0][0]=true;
        while(!pq.isEmpty()){
            int[] cur= pq.poll();
            for(int[] dir:directions){
                int ni=cur[0]+dir[0];
                int nj=cur[1]+dir[1];
                if(valid(moveTime,ni,nj) && !visited[ni][nj]){
                    int next=Math.max(cur[2]+1,moveTime[ni][nj]+1)+cur[3];
                    if(ni==n-1 && nj==m-1) return next;
                    pq.add(new int[] {ni,nj,next,cur[3]^1});
                    visited[ni][nj]=true;
                }
            }
        }
        return 0;
    }
    public boolean valid(int[][] grid,int i,int j){
        return i>=0 && j>=0 && i<grid.length && j<grid[0].length;
    }
}