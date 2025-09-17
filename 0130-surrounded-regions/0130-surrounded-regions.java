class Solution {
    int[][] directions ={{-1,0},{0,1},{1,0},{0,-1}};
    public void solve(char[][] board) {
        for(int i=0;i<board.length;i++){
            if(board[i][0]=='O'){
                board[i][0]='Y';
                bfs(board,i,0);
            }
            if(board[i][board[0].length-1]=='O'){
                board[i][board[0].length-1]='Y';
                bfs(board,i,board.length-1);
            }
        }
        for(int i=0;i<board[0].length;i++){
            if(board[0][i]=='O'){
                board[0][i]='Y';
                bfs(board,0,i);
            }
            if(board[board.length-1][i]=='O'){
                board[board.length-1][i]='Y';
                bfs(board,board.length-1,i);
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='O') board[i][j]='X';
                if(board[i][j]=='Y') board[i][j]='O';
            }
        }
    }
    public void bfs(char[][] board, int i , int j){
        Queue<int[]> q= new LinkedList<>();
        q.add(new int[] {i,j});
        while(!q.isEmpty()){
            int[] cur=q.poll();
            for(int[] dir:directions){
                int ni=dir[0]+cur[0];
                int nj=dir[1]+cur[1];
                if(valid(board,ni,nj)){
                    board[ni][nj]='Y';
                    q.add(new int[] {ni,nj});
                }
            }
        }
    }
    public boolean valid(char[][] grid,int i,int j){
        return i>=0 && j>=0 && i<grid.length && j<grid[0].length && grid[i][j]=='O';
    }
}