class Solution {
    public int maxFreqSum(String s) {
     int[] freq= new int[26];
     int vc=0,cc=0;
     for(char c:s.toCharArray()){
        freq[c-'a']++;
        if("aeiou".indexOf(c)==-1) cc=Math.max(cc,freq[c-'a']);
        else vc=Math.max(vc,freq[c-'a']);
     }   
     return cc+vc;
    }
}