class Solution {
    public String longestPalindrome(String s) {
        int maxlen=0;
        int[] ans=new int[2];
        for(int i=0;i<s.length();i++){
            if(i>=1){
                int[] temp1=palin(s,i-1,i);
            if(temp1[1]-temp1[0]+1>maxlen){
                ans=temp1;
                maxlen=temp1[1]-temp1[0]+1;
            } 
            }
            int[] temp=palin(s,i,i);
            if(temp[1]-temp[0]+1>maxlen){
                ans=temp;
                maxlen=temp[1]-temp[0]+1;
            } 
        }
        return s.substring(ans[0],ans[1]+1);
    }
    public int[] palin(String s,int l,int r){
        while(r<s.length() && l>=0 && s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }
        return new int[] {l+1,r-1};
    }
}