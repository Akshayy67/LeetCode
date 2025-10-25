class Solution {
    public long numberOfWays(String s) {
        int zero=0,one=0;
        long oneZero=0,zeroOne=0,total=0;
        for(char c:s.toCharArray()){
            if(c=='0'){
                zero++;
                oneZero+=one;  // each prev one can pair up to zero to form onezero"10"
                total+=zeroOne;
            }
            else{
                one++;
                zeroOne+=zero;  // each prev zero can pair up to one to form onezero"10"
                total+=oneZero;
            }
        }
        return total;
    }
}