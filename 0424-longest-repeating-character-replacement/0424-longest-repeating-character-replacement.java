class Solution {
    public int characterReplacement(String s, int k) {
        int j=0,count=0,max=0;
        int[] freq= new int[27];
        for(int i=0;i<s.length();i++){
            int c=s.charAt(i)-'A';
            freq[c]++;
            count=Math.max(count,freq[c]);
            if(i-j-count+1>k){
                freq[s.charAt(j++)-'A']--;
            }
            max=Math.max(max,i-j+1);
        }
        return max;
    }
}