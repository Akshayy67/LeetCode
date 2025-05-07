import java.util.*;
class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int[][] directions= {{-1,0},{0,1},{1,0},{0,-1}};
        int n=moveTime.length,m=moveTime[0].length;
        boolean[][] visited= new boolean[n][m];
        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->a[2]-b[2]);
        pq.add(new int[] {0,0,0 });
        visited[0][0]=true;
        while(!pq.isEmpty()){
            int[] cur= pq.poll();
            for(int[] dir:directions){
                int ni=dir[0]+cur[0];
                int nj=dir[1]+cur[1];
                if(valid(moveTime,ni,nj) && !visited[ni][nj]){
                    visited[ni][nj]=true;
                    int next=Math.max(moveTime[ni][nj]+1,cur[2]+1);
                    if(ni==n-1 && nj==m-1) return next;
                    pq.add(new int[] {ni,nj,next});
                }
            }
        }
        return -1;
    }
    public boolean valid(int[][] grid,int i,int j){
        return i>=0 && j>=0 && i<grid.length && j<grid[0].length;
    }
}