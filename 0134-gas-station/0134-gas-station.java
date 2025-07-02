class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total=0,idx=0,cur=0;
        for(int i=0;i<gas.length;i++){
            int rem=gas[i]-cost[i];
            total+=rem;
            cur+=rem;
            if(cur<0){
                cur=0;
                idx=i+1;
            }
        }
        return total>=0?idx:-1;
    }
}