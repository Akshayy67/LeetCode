class Solution {
    public boolean checkRecord(String s) {
        int count=0,absent=0;
        for(char c:s.toCharArray()){
            if(c=='L'){
                count++;
                if(count==3) return false;
            }
            else{
                count=0;
                if(c=='A') absent++;
                if(absent==2) return false;
            }
        }
        return true;
    }
}