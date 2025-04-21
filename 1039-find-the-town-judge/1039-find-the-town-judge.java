class Solution {
    public int findJudge(int n, int[][] trust) {
        int[][] deg=new int[n][2];
        for(int[] trus:trust){
            deg[--trus[0]][0]++;
            deg[--trus[1]][1]++;
        }
        for(int i=0;i<n;i++){
            if(deg[i][0]==0 && deg[i][1]==n-1) return ++i;
        }
        return -1;
    }
}