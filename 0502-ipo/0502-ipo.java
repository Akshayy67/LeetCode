class Pair{
    int profit;
    int capital;
    public Pair(int profit,int capital){
        this.profit=profit;
        this.capital=capital;
    }
}
class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        List<Pair> list= new ArrayList<>();
        for(int i=0;i<profits.length;i++){
            list.add(new Pair(profits[i],capital[i]));
        }
        Collections.sort(list,(a,b)->{
            if(a.capital==b.capital) return a.profit-b.profit;
            return a.capital-b.capital;
        });
        return helper(list,0,w,k);
    }
    public int helper(List<Pair> list,int i,int balance,int k){
        if(i==list.size() || k==0) return 0;
        int leave= helper(list,i+1,balance,k);
        int take=0;
        if(balance>=list.get(i).capital)
        take=helper(list,i+1,balance-list.get(i).capital+list.get(i).profit,k-1)+list.get(i).profit;
        return Math.max(leave,take);
    }
}