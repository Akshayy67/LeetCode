class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int count=0;
        Map<String,Integer> mp= new HashMap<>();
        for(int[] di:dominoes){
            Arrays.sort(di);
            String d= Arrays.toString(di);
            count+=mp.getOrDefault(d,0);
            mp.put(d,mp.getOrDefault(d,0)+1);
        }
        return count;
    }
    // public boolean valid(int[][] dominoes,int i,int j){
    //     return ((dominoes[i][0]==dominoes[j][0] && dominoes[i][1]==dominoes[j][1]) 
    //     ||  (dominoes[i][0]==dominoes[j][1]  && dominoes[i][1]==dominoes[j][0]));
    // }
}