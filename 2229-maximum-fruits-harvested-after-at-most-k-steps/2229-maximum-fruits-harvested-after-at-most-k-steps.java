class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int result=0,sum=0,j=0;
        for(int i=0;i<fruits.length;i++){
            sum+=fruits[i][1];
            while(j<=i && !possible(fruits[j][0],fruits[i][0],startPos,k)) sum-=fruits[j++][1];
            result= Math.max(result,sum);
        }
        return result;
    }
    public boolean possible(int j,int i,int pos,int k){
        int min=Math.min(Math.abs(i-pos),Math.abs(j-pos))+(i-j);
        return min<=k;
    }
}