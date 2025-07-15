class Solution {
    public boolean isValid(String word) {
        if(word.length()<3) return false;
        boolean v=false,con=false;
        String vow="aeiou";
        String Vow="AEIOU";
        for(char c:word.toCharArray()){
            if(c>='a' && c<='z'){
                if(vow.indexOf(c)==-1)con=true;
                else v=true;
            }
            else if(c>='A' && c<='Z'){
                if(Vow.indexOf(c)==-1)con=true;
                else v=true;
            }
            else if(c>='0' && c<='9'){
                continue;
            }
            else return false;
        }
        return con&v;
    }
}