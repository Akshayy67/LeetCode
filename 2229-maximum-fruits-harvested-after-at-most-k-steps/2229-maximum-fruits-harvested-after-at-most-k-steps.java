class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int j=0,result=0,sum=0;
        for(int i=0;i<fruits.length;i++){
            sum+=fruits[i][1];
            while(j<=i && !isPossible(fruits[i][0],fruits[j][0],startPos,k)) sum-=fruits[j++][1];
            result=Math.max(result,sum);
        }
        return result;
    }
    public boolean isPossible(int i,int j,int sp,int k){
        int min=Math.min(Math.abs(sp-i),Math.abs(sp-j))+(i-j);
        return min<=k;
    }
}