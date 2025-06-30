class Solution {
    public int findLHS(int[] nums) {
        Map<Integer,Integer> mp= new HashMap<>();
        int result=0;
        for(int num:nums) mp.put(num,mp.getOrDefault(num,0)+1);
        for(int key:mp.keySet()){
            if(mp.containsKey(key+1)){
                result=Math.max(result,mp.get(key)+mp.get(key+1));
            }
        }
        return result;
    }
}