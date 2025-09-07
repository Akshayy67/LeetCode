class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk= new Stack<>();
        for(String token:tokens){
            try{
                int num=Integer.parseInt(token);
                stk.push(num);
            }
            catch(Exception e){
                int b=stk.pop(),a=stk.pop();
                if(token.equals("+")) stk.push(a+b);
                if(token.equals("-")) stk.push(a-b);
                if(token.equals("/")) stk.push(a/b);
                if(token.equals("*")) stk.push(a*b);
            }
        }
        return stk.peek();
    }
}