class Solution {
    public long getDescentPeriods(int[] prices) {
        long result=1,cur=1;
        for(int i=1;i<prices.length;i++){
            if(prices[i]==prices[i-1]-1) cur++;
            else cur=1;
            result+=cur;
        }
        return result;
   }
}