class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] xor= new int[arr.length+1];
        for(int i=0;i<xor.length-1;i++){
            xor[i+1]=xor[i]^arr[i];
        }
        int[] result= new int[queries.length];
        for(int i=0;i<queries.length;i++){
            result[i]=xor[queries[i][0]]^xor[queries[i][1]+1];
        }
        return result;
    }
}