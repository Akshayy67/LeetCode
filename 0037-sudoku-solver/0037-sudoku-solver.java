class Solution {
    int[] rows= new int[9];
    int[] cols= new int[9];
    int[] dabba= new int[9];
    List<int[]> empty= new ArrayList<>();
    public void solveSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    empty.add(new int[] {i,j});
                    continue;
                }
                int num=board[i][j]-'1';
                int bit=1<<num;
                rows[i]|=bit;
                cols[j]|=bit;
                int dabbaidx=(i/3)*3+j/3;
                dabba[dabbaidx]|=bit;
            }
        }
        helper(board,0);
    }
    public boolean helper(char[][] board,int i){
        if(i==empty.size()) return true;
        int ni=empty.get(i)[0];
        int nj=empty.get(i)[1];
        for(int num=0;num<9;num++){
            int bit=1<<num;
            if((rows[ni]&bit)!=0) continue;
            if((cols[nj]&bit)!=0) continue;
            int dabbaidx=(ni/3)*3+nj/3;
            if((dabba[dabbaidx]&bit)!=0) continue;
            rows[ni]|=bit;
            cols[nj]|=bit;
            dabba[dabbaidx]|=bit;
            board[ni][nj]=(char)(num+'1');
            if(helper(board,i+1)) return true;
            board[ni][nj]='.';
            rows[ni]^=bit;
            cols[nj]^=bit;
            dabba[dabbaidx]^=bit;
        }
        return false;
    }
}