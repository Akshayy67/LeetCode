class Solution {
    int[][] directions={{-1,0},{0,1},{1,0},{0,-1}};
    public boolean exist(char[][] board, String word) {
        boolean[][] visited= new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                // visited[i][j]=true;
                if(backTrack(board,i,j,0,visited,word)) return true;
                // visited[i][j]=false;
            }
        }
        return false;
    }
    public boolean backTrack(char[][] board,int i,int j,int k,boolean[][] visited,String word){
        if(visited[i][j]) return false;
        if(k==word.length()-1) return word.charAt(k)==board[i][j];
        if(board[i][j]!=word.charAt(k)) return false;
                visited[i][j]=true;
        for(int[] dir:directions){
            int ni=dir[0]+i;
            int nj=dir[1]+j;
            if(valid(board,ni,nj) && !visited[ni][nj]){
                if(backTrack(board,ni,nj,k+1,visited,word)) return true;
            }
        }
                visited[i][j]=false;
        return false;
    }
    public boolean valid(char[][] board,int i, int j){
        return i>=0 && j>=0 && i<board.length && j<board[0].length;
    }
}