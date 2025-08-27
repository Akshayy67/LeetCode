class Solution {
    public int maxConsecutiveAnswers(String s, int k) {
        int t=0,f=0,j=0;
        int result=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='T') t++;
            else f++;
            while(Math.min(t,f)>k){    
                if(s.charAt(j)=='T') t--;
                else f--;
                j++;
            }
            result=Math.max(result,t+f);
        }
        return result;
    }
}