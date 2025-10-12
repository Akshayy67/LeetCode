class Solution {
    public String addBinary(String a, String b) {
        int i=a.length()-1,j=b.length()-1;
        int carry=0;
        StringBuilder result= new StringBuilder();
        while(i>=0 || j>=0 || carry==1){
            int num1=(i>=0)?a.charAt(i)-'0':0;
            int num2=(j>=0)?b.charAt(j)-'0':0;
            int sum=(num1+num2+carry)%2;
            carry=(num1+num2+carry)/2;
            result.append(sum);
            i--;j--;
        }
        return result.reverse().toString();
    }
}