class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Set<Character>[] rows= new HashSet[9];
        // Set<Character>[] cols= new HashSet[9];
        // Set<Character>[][] dabba= new HashSet[3][3];
        // for(int i=0;i<9;i++){
        //     rows[i]=new HashSet<>();
        //     cols[i]=new HashSet<>();
        // }
        // for(int i=0;i<3;i++){
        //     for(int j=0;j<3;j++){
        //         dabba[i][j]= new HashSet<>();
        //     }
        // }
        // for(int i=0;i<9;i++){
        //     for(int j=0;j<9;j++){
        //         if(board[i][j]=='.') continue;
        //         if(rows[i].contains(board[i][j])) return false;
        //         if(cols[j].contains(board[i][j])) return false;
        //         if(dabba[i/3][j/3].contains(board[i][j])) return false;
        //         rows[i].add(board[i][j]);
        //         cols[j].add(board[i][j]);
        //         dabba[i/3][j/3].add(board[i][j]);
        //     }
        // }
        // return true;
        int[] rows= new int[9];
        int[] cols= new int[9];
        int[] dabba= new int[9];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.') continue;
                int num=board[i][j]-'1';
                int v=1<<num;
                int dabbaidx=(i/3)*3+j/3;
                if((rows[i]&v)!=0 || (cols[j]&v)!=0 || (dabba[dabbaidx]&v)!=0) return false;
                rows[i]|=v;
                cols[j]|=v;
                dabba[dabbaidx]|=v;
            }
        }
        return true;
    }
}