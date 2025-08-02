class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer,Integer> mp= new HashMap<>();
        int min=Integer.MAX_VALUE,n=basket1.length;
        for(int i=0;i<n;i++){
            mp.put(basket1[i],mp.getOrDefault(basket1[i],0)+1);
            mp.put(basket2[i],mp.getOrDefault(basket2[i],0)-1);
            min=Math.min(min,Math.min(basket1[i],basket2[i]));
        }
        List<Integer> list= new ArrayList<>();
        for(int key:mp.keySet()){
            if(mp.get(key)%2!=0) return -1;
            for(int i=0;i<Math.abs(mp.get(key)/2);i++){
                list.add(key);
            }
        }
        Collections.sort(list);
        long result=0;
        for(int i=0;i<list.size()/2;i++){
            result+=Math.min(2*min,list.get(i));
        }
        return result;
    }
}