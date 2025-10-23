class Solution {
    public boolean hasSameDigits(String s) {
        while(s.length()>2){
            StringBuilder str= new StringBuilder();
            for(int i=0;i<s.length()-1;i++){
                str.append((s.charAt(i)-'0'+s.charAt(i+1)-'0')%10);
            }
            s=str.toString();
        }
        return s.charAt(0)==s.charAt(1);
    }
}