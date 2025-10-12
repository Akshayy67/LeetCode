class Solution {
    public int[] plusOne(int[] digits) {
        int i=0;
        for(i=0;i<digits.length;i++){
            if(digits[i]!=9) break;
        }
        if(i==digits.length){
            int[] result=new int[digits.length+1];
            result[0]=1;
            return result;
        }
        int carry=1;
        i=digits.length-1;
        while(carry!=0 && i>=0){
            digits[i]+=carry;
            carry=digits[i]/10;
            digits[i]%=10;
            i--;
        }
        return digits;
    }
}