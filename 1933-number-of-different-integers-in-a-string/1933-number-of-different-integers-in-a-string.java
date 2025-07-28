class Solution {
    public int numDifferentIntegers(String word) {
        Set<String> st= new HashSet<>();
        int i=0;
        while(i<word.length()){
            boolean isZero=false;
            StringBuilder str= new StringBuilder();
            while(i<word.length() && word.charAt(i)>='0' && word.charAt(i)<='9'){
                if(str.length()==0 && word.charAt(i)=='0') {
                    i++;
                    isZero=true;
                    continue;
                }
                str.append(word.charAt(i));
                i++;
            }
            if(str.length()==0 && isZero) str.append('0'); 
            if(!str.isEmpty()) st.add(str.toString());
            i++;
        }
        return st.size();
    }
}