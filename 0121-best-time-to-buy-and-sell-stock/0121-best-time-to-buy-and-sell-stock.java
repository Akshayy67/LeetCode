class Solution {
    public int maxProfit(int[] prices) {
      int result=0;
      int min=prices[0];
      for(int num:prices){
        result=Math.max(result,num-min);
        min=Math.min(num,min);
      }  
      return result;
    }
}