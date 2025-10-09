class Solution {
    public String longestPalindrome(String s) {
        String result= "";
       for(int i=0;i<s.length();i++){
        for(int j=i+1;j<=s.length();j++){
            String sub=s.substring(i,j);
            if(isPalin(sub) && sub.length()>result.length()){
                result=new String(sub);
            }
        }
       }
       return result;
    }
    public boolean isPalin(String s){
        int i=0,j=s.length()-1;
        while(i<j && s.charAt(i)==s.charAt(j)){
            i++;j--;
        }
        return i>=j;
    }
}