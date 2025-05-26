class Solution {
    public boolean checkValid(int[][] matrix) {
        // Set<Integer> st= new HashSet<>();
        for(int i=0;i<matrix.length;i++){
            Set<Integer> st= new HashSet<>();
            for(int j=0;j<matrix[0].length;j++){
                st.add(matrix[i][j]);
            }
            if(st.size()!=matrix.length) return false;
        }
        for(int i=0;i<matrix.length;i++){
            Set<Integer> st= new HashSet<>();
            for(int j=0;j<matrix[0].length;j++){
                st.add(matrix[j][i]);
            }
            if(st.size()!=matrix.length) return false;
        }
        return true;
    }
}