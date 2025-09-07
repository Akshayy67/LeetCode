class Solution {
    public int calculate(String s) {
        int result=0;
        int num=0;
        int sign=1;
        Stack<Integer> stk= new Stack<>();
        for(char c:s.toCharArray()){
            if(Character.isDigit(c)) num=num*10+(c-'0');
            else if(c=='('){
                result+=num*sign;
                num=0;
                stk.push(result);
                stk.push(sign);
                result=0;
                sign=1;
            }
            else if(c==')'){
                result+=num*sign;
                num=0;
                int prevsign=stk.pop();
                int prevres=stk.pop();
                result=prevres+prevsign*result;
            }
            else if (c=='+' || c=='-'){
                result=result+num*sign;
                num=0;
                sign=(c=='+')?1:-1;
            }
        }
        return result+sign*num;
    }
}