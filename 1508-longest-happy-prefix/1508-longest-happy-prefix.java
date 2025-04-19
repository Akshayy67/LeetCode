class Solution {
    public String longestPrefix(String s) {
        int[] lps= new int[s.length()];
        int i=1,j=0,max=0;
        while(i<s.length()){
            if(s.charAt(i)==s.charAt(j)){
                j++;
                lps[i]=j;
                i++;
                max=Math.max(max,j);
            }
            else{
                if(j==0) i++;
                else j=lps[j-1];
            }
        }
        return max==0?"":s.substring(0,lps[s.length()-1]);
    }
}