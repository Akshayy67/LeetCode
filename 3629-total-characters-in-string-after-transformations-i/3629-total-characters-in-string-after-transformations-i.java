class Solution {
    int mod=(int)1e9+7;
    public int lengthAfterTransformations(String s, int t) {
        long[] freq= new long[26];
        for(char c:s.toCharArray()) freq[c-'a']++;
        long result=0;
        for(int j=0;j<t;j++){
            long[] newFreq= new long[26];
            for(int i=1;i<26;i++){
                newFreq[i]=freq[i-1];
            }
            newFreq[0]=(newFreq[0]+freq[25])%mod;
            newFreq[1]=(newFreq[1]+freq[25])%mod;
            freq= newFreq;
        }
        for(int i=0;i<26;i++){
            result= (result+freq[i])%mod;
        }
        return (int)result;

        // for(int i=0;i<26;i++){
        //     int dif='z'-(char)('a'+i);
        //     result+=freq[i]*t+((dif==0)?0:freq[i]/dif)*t;
        // }
        // return result;
        // // return helper(s,t).length();
    }
    // public String helper(String s,int t){
    //     if(t==0) return s;
    //     StringBuilder str= new StringBuilder();
    //     for(char c:s.toCharArray()){
    //         if(c=='z'){
    //             str.append("ab");
    //         }
    //         else str.append((char) (c+1));
    //     }
    //     return helper(str.toString(),t-1);
    // }
}