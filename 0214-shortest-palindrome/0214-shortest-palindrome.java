class Solution {
    public String shortestPalindrome(String s) {
        String rev=new StringBuilder(s).reverse().toString();
        String com=s+'#'+rev;
        int[] lps=computeLPS(com);
        int len=s.length()-lps[lps.length-1];
        return rev.substring(0,len)+s;
    }
    public int[] computeLPS(String s){
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
        return lps;
    }
}