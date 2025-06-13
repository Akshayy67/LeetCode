class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer,Integer> mp= new HashMap<>();
        for(int task:tasks){
            mp.put(task,mp.getOrDefault(task,0)+1);
        }
        int result=0;
        for(int key:mp.keySet()){
            if(mp.get(key)<2) return -1;
            result+=(int)Math.ceil(mp.get(key)/3.0);
        }
        return result;
    }
}