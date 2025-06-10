class Solution {
    public int maxDifference(String s) {
        int o=0,e=Integer.MAX_VALUE;
        int[] freq= new int[26];
        for(char c:s.toCharArray()){
            int idx=c-'a';
            freq[idx]++;
        }
        for(int i=0;i<26;i++){
            if(freq[i]%2==1){
                o=Math.max(o,freq[i]);
            }
            else if(freq[i]>0){
                e=Math.min(e,freq[i]);
            }
        }
        if(e==Integer.MAX_VALUE) return o;
        return o-e;
    }
}