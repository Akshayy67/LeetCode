class Solution {
    int mod= (int)1e9+7;
    public int numSub(String s) {
        int result=0,count=0;
        for(char c:s.toCharArray()){
            if(c=='1'){
                count=(count+1)%mod;
                result=(result+count)%mod;
            }
            else{
                count=0;
            }
        }
        return result;
    }
}