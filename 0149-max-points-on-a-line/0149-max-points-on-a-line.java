class Solution {
    public int maxPoints(int[][] points) {
        int max=0;
        if(points.length==1) return 1;
        for(int i=0;i<points.length;i++){
            int[] p1=points[i];
            Map<Double,Integer> mp= new HashMap<>();
            for(int j=0;j<points.length;j++){
                if(i==j) continue;
                int[] p2=points[j];
                if(p1[0]==p2[0]){
                    mp.put(Double.MAX_VALUE,mp.getOrDefault(Double.MAX_VALUE,0)+1);
                    // max=Math.max(max,mp.get(Double.MAX_VALUE)+1);
                }
                else{
                    Double slope=(p2[1]-p1[1])*1.0/(p2[0]-p1[0]);
                    mp.put(slope,mp.getOrDefault(slope,0)+1);
                    // max=Math.max(max,mp.get(slope)+1);
                }
                max=Math.max(max,Collections.max(mp.values())+1);
            }
        }
        return max;
    }
}