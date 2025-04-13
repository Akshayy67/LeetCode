class Solution {
    public int myAtoi(String s) {
        if(s==null || s.length()==0) return 0;
        long result=0;
        int i=0;boolean flag=false;
        while(i<s.length() && s.charAt(i)==' ') i++;
        if(i==s.length()) return 0;
        if(s.charAt(i)=='-'){
            flag=true;i++;
        } 
        else if(s.charAt(i)=='+') i++;
        while(i<s.length()){
            int temp=s.charAt(i)-'0';
            if(temp<0 || temp>9) break;
            result=result*10;
            result+=temp;
            if(result>Integer.MAX_VALUE) return flag?Integer.MIN_VALUE:Integer.MAX_VALUE;
            i++;
        }
        return flag?(int)-result:(int)result;
    }
}