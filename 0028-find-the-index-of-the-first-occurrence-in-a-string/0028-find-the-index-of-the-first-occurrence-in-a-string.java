class Solution {
    public int strStr(String haystack, String needle) {
        int[] lps= new int[needle.length()];
        int i=1,j=0;
        while(i<needle.length()){
            if(needle.charAt(i)==needle.charAt(j)){
                j++;
                lps[i]=j;
                i++;
            }
            else{
                if(j!=0) j=lps[j-1];
                else i++;
            }
        }
        i=0;j=0;
        while(i<haystack.length()){
            if(j==needle.length()) return i-j;
            if(needle.charAt(j)==haystack.charAt(i)){
                i++;
                j++;
            }
            else{
                if(j!=0) j=lps[j-1];
                else i++;
            }
        }
        if(j==needle.length()) return i-j;
        return -1;
    }
}