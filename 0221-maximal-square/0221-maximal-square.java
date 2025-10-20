class Solution {
    public int maximalSquare(char[][] matrix) {
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][j]=='1'){
                    matrix[i][j]=(char) (Math.min(matrix[i][j-1],Math.min(matrix[i-1][j],matrix[i-1][j-1]))+1);
                }
            }
        }
        int max=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                max=Math.max(max,matrix[i][j]-'0');
            }
        }
        return max*max;
    }
}