class Solution {
    public String largestGoodInteger(String num) {
        String str= "";
        for(int i=0;i<num.length()-2;i=i+1){
            if(num.charAt(i)!=num.charAt(i+1) || num.charAt(i+1)!=num.charAt(i+2)) continue;
            if(str.length()==0)
                str=num.substring(i,i+3);
            else if(str.charAt(0)-num.charAt(i)<0){
                str=num.substring(i,i+3);
            }
        }
        return str;
    }
}