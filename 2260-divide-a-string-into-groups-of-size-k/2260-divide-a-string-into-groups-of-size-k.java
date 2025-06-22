class Solution {
    public String[] divideString(String s, int k, char fill) {
        String[] result= new String[(int)Math.ceil(s.length()/(k*1.0))];
        int i=0;
        while(i+k<=s.length()){
            String sub=s.substring(i,i+k);
            result[i/k]=sub;
            i+=k;
        }
        if(i!=s.length()){
            StringBuilder sub= new StringBuilder(s.substring(i,s.length()));
            while(sub.length()<k){
                sub.append(fill);
            }
            result[result.length-1]=sub.toString();
        }
        return result;
    }
}