class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int[] lps= new int[s.length()];
        int i=1,j=0;
        while(i<s.length()){
            if(s.charAt(i)==s.charAt(j)){
                j++;
                lps[i]=j;
                i++;
            }
            else{
                if(j==0) i++;
                else j=lps[j-1];
            }
        }
        int len=lps[lps.length-1];
        return len>0 && s.length()%(s.length()-len)==0;
    }
}