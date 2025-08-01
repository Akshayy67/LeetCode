class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        long ans=0;
        Map<Double,Integer> mp= new HashMap<>();
        for(int[] rect:rectangles){
            double key =(double)rect[0]/(rect[1]*1.0);
            mp.put(key,mp.getOrDefault(key,0)+1);
        }
        for(double key:mp.keySet()){
            if(mp.get(key)!=1){
                int num=mp.get(key);
                ans+=((long)num*(num-1))/2;
            }
        }
        return ans;
    }
}