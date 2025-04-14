class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int ei=entrance[0],ej=entrance[1];
        maze[ei][ej]='+';
        Queue<int[]> q= new LinkedList<>();
        q.add(new int[] {ei,ej});
        int[][] directions={{0,-1},{0,1},{1,0},{-1,0}};
        int count=0;
        while(!q.isEmpty()){
            int len=q.size();
            while(len-->0){
                int[] cur=q.poll();
                for(int[] dir:directions){
                    int ni=cur[0]+dir[0];
                    int nj=cur[1]+dir[1];
                    if(valid(maze,ni,nj)){
                        if(ni==maze.length-1 || nj==maze[0].length-1 || ni==0 || nj==0) return ++count;
                        q.add(new int[] {ni,nj});
                        maze[ni][nj]='+';
                    }
                }
            }
            count++;
        }
        return -1;
    }
    public boolean valid(char[][] maze,int i, int j){
        return i>=0 && j>=0 && i<maze.length && j<maze[0].length && maze[i][j]!='+';
    }
}