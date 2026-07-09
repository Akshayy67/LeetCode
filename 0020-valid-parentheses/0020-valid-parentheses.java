class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for(char c:s.toCharArray()){
            if(c==')'){
                if(stk.isEmpty() || stk.peek()!='(') return false;
                stk.pop();
            }
            else if(c==']'){
                if(stk.isEmpty() || stk.peek()!='[') return false;
                stk.pop();
            }
            else if(c=='}'){
                 if(stk.isEmpty() || stk.peek()!='{') return false;
                stk.pop();
            }
            else{
                stk.push(c);
            }
        }
        return stk.isEmpty();
    }
}