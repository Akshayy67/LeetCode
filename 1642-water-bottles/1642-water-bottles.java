class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
       int extra=0,result=0;
       while(numBottles>0){
            result+=numBottles;
            extra+=numBottles;
            numBottles=extra/numExchange;
            extra=extra%numExchange;
       }
       return result;
    }
}