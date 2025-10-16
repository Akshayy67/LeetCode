class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        Map<Integer,Integer> mp= new HashMap<>();
        for(int num:nums){
            int mod=(num%value+value)%value;
            mp.put(mod,mp.getOrDefault(mod,0)+1);
        }
        int x=0;
        while(true){
            for(int i=0;i<value;i++){
                if(!mp.containsKey(i)) return x;
                mp.put(i,mp.get(i)-1);
                if(mp.get(i)==0) mp.remove(i);
                x++;
            }
        }
        // return -1;
    }
}