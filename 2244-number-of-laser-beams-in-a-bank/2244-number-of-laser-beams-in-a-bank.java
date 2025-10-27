class Solution {
    public int numberOfBeams(String[] bank) {
        int result=0,prev=0;
        for(String s:bank){
            int count=0;
            for(char c:s.toCharArray()){
                if(c-'0'==1){
                     count++;
                }
            }
            result+=prev*count;
            if(count>0) prev=count;
        }
        return result;
    }
}