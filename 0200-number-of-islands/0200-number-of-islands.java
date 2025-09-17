class Solution {
    int[][] directions= {{-1,0},{0,1},{1,0},{0,-1}};
    public int numIslands(char[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    bfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    public void bfs(char[][] grid,int i,int j){
        Queue<int[]> q= new LinkedList<>();
        q.offer(new int[] {i,j});
        while(!q.isEmpty()){
            int[] cur=q.poll();
            for(int[] dir:directions){
                int ni=cur[0]+dir[0];
                int nj=cur[1]+dir[1];
                if(valid(grid,ni,nj)) q.offer(new int[] {ni,nj});
            }
        }
    }
    public boolean valid(char[][] grid,int i,int j){
        if(i>=0 && j>=0 && i<grid.length && j<grid[0].length && grid[i][j]=='1'){
            grid[i][j]='0';
            return true;
        }
        return false;
    }
}