class Solution {
    public int minimumDeletions(String word, int k) {
        int[] freq= new int[26];
        int result=Integer.MAX_VALUE;
        for(char c:word.toCharArray()){
            freq[c-'a']++;
        }
        for(int f:freq){
            int deleted=0;
            for(int frq:freq){
                if(frq<f) deleted+=frq;
                if(frq>f+k) deleted+=frq-f-k;
            }
            result=Math.min(deleted,result);
        }
        return result;
    }
}