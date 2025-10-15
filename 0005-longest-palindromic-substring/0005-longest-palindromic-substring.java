class Solution {
    public String longestPalindrome(String s) {
        String result="";
        for(int i=0;i<s.length();i++){
            int[] temp;
            if(i!=s.length()-1){
                temp=helper(s,i,i+1);
                if(temp[1]-temp[0]>result.length()) result=s.substring(temp[0],temp[1]);
            }
                temp=helper(s,i,i);
                if(temp[1]-temp[0]>result.length()) result=s.substring(temp[0],temp[1]);
        }
        return result;
    }
    public int[] helper(String s,int i,int j){
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
            i--;j++;
        }
        return new int[] {i+1,j};
    }
}