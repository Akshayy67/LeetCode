class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
       int empty=numBottles,result=numBottles;
        while(empty>=numExchange){
            int newBottles=empty/numExchange;
            result+=newBottles;
            empty=empty%numExchange+newBottles;
        }
        return result;
    }
}