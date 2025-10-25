class Solution {
    public int totalMoney(int n) {
        int total=0;
        for(int i=1;i<=n;i++){
            if(i%7==0) total+=6;
            total+=i%7+Math.ceil(i/7);
        }
        return total;
    }
}