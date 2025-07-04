class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk= new Stack<>();
        for(String s:tokens){
                if(s.equals("+")) stk.push(stk.pop()+stk.pop());
                else if(s.charAt(0)=='*') stk.push(stk.pop()*stk.pop());
                else if(s.compareTo("-")==0) stk.push(-stk.pop()+stk.pop());
                else if((s.charAt(0)-'/')==0){
                    int b=stk.pop();
                    int a=stk.pop();
                    stk.push(a/b);
                }
                else stk.push(Integer.parseInt(s));
        }
        return stk.pop();
    }
}