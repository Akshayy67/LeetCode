class Solution {
    public int findLucky(int[] arr) {
        Map<Integer,Integer> mp= new HashMap<>();
        int result=-1;
        for(int num:arr){
            mp.put(num,mp.getOrDefault(num,0)+1);
        }
        for(int key:mp.keySet()){
            if(key==mp.get(key)) result=Math.max(result,key);
        }
        return result;
    }
}