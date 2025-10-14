class Solution {
    public boolean isUgly(int n) {
        if(n==0) return false;
        if(n==1) return true;
        if(n%2==0) if(isUgly(n/2)) return true;
        if(n%3==0) if(isUgly(n/3)) return true;
        if(n%5==0) if(isUgly(n/5)) return true;
        return false;
    }
}