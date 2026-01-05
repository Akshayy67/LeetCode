class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum=0;
        int count=0,min=Integer.MAX_VALUE;
        boolean has_zero=false;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                min=Math.min(min,Math.abs(matrix[i][j]));
                sum+=Math.abs(matrix[i][j]);
                if(matrix[i][j]<0) count++;
            }
        }
        return sum-(count%2==1?2*min:0);
    }
}