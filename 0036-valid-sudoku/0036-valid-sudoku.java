class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows= new HashSet[9];
        Set<Character>[] cols= new HashSet[9];
        Set<Character>[][] dabba= new HashSet[3][3];
        for(int i=0;i<9;i++){
            rows[i]=new HashSet<>();
            cols[i]=new HashSet<>();
        }
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                dabba[i][j]= new HashSet<>();
            }
        }
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.') continue;
                if(rows[i].contains(board[i][j])) return false;
                if(cols[j].contains(board[i][j])) return false;
                if(dabba[i/3][j/3].contains(board[i][j])) return false;
                rows[i].add(board[i][j]);
                cols[j].add(board[i][j]);
                dabba[i/3][j/3].add(board[i][j]);
            }
        }
        return true;
    }
}