class Pair{
    StringBuilder s;
    int count;
    public Pair(int count){
        this.count=count;
        s= new StringBuilder();
    }
}
class Solution {
    public String decodeString(String s) {
        Stack<Pair> stk= new Stack<>();
        stk.push(new Pair(1));
        int num=0;
        for(char c:s.toCharArray()){
            if(Character.isDigit(c)){
                num=num*10+c-'0';
                continue;
            }
            if(c=='['){
                stk.push(new Pair(num));
                num=0;
                continue;
            } 
            if(c==']'){
                StringBuilder str= new StringBuilder();
                for(int i=0;i<stk.peek().count;i++){
                    str.append(stk.peek().s);
                }
                stk.pop();
                stk.peek().s.append(str);
            }
            else{
                stk.peek().s.append(c);
            }
        }
        return stk.peek().s.toString();
    }
}