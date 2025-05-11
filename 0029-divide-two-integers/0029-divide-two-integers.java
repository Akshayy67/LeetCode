class Solution {
    public int divide(int dividend, int divisor) {
        long ans= (long)dividend/divisor;
        return ans>Integer.MAX_VALUE?Integer.MAX_VALUE: ans<Integer.MIN_VALUE?Integer.MAX_VALUE:(int)ans;
    }
}