class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int result=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(i+3>grid.length || j+3>grid[0].length) continue;
                // int row1=grid[i][j]+grid[i][j+1]+grid[i][j+2];
                // int row2=grid[i+1][j]+grid[i+1][j+2]+grid[i+1][j+2];
                // int row3=grid[i+2][j]+grid[i+2][j+1]+grid[i+2][j+2];
                // int col1=grid[i][j]+grid[i+1][j]+grid[i+2][j];
                // int col2=grid[i][j+1]+grid[i+1][j+1]+grid[i+2][j+1];
                // int col3=grid[i][j+2]+grid[i+1][j+2]+grid[i+2][j+2];
                // int dia1=grid[i][j]+grid[i+1][j+1]+grid[i+2][j+2];
                // int dia2=grid[i][j+2]+grid[i+1][j+1]+grid[i+2][j];
                int[] rows= new int[3];
                int[] cols= new int[3];
                int mask=0,dia1=0,dia2=0;
                boolean maskk=false;
                for(int ni=i;ni<i+3;ni++){
                    for(int nj=j;nj<j+3;nj++){
                        if(grid[ni][nj] < 1  || grid[ni][nj]>9 || ((mask>>grid[ni][nj])&1)==1){
                            maskk=true;
                            // System.out.println(grid[ni][nj]);
                            break;
                        }
                        mask|=(1<<grid[ni][nj]);
                        rows[ni-i]+=grid[ni][nj];
                        cols[nj-j]+=grid[ni][nj];
                        if(ni-i==(nj-j)) dia1+=grid[ni][nj]; 
                        if (ni+nj-i-j== 2) dia2 += grid[ni][nj];
                    }
                    if(maskk) continue;
                }
                if(maskk) continue;
                if(rows[0]==15 && rows[1]==15 && rows[2]==15 && cols[0]==15 && cols[1]==15 && cols[2]==15 && dia1==15 && dia2==15) result++;
            }
        }
        return result;
    }
}