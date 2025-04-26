class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stk= new Stack<>();
        boolean[] b= new boolean[s.length()];
        Arrays.fill(b,true);
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='(') {
                stk.push(i);
                b[i]=false;
            }
            else if(!stk.isEmpty() && c==')'){
                b[stk.pop()]=true;
            }
            else if(s.charAt(i)==')'){
                b[i]=false;
            }
        }
        StringBuilder str= new StringBuilder();
        for(int i=0;i<b.length;i++){
            if(b[i]) str.append(s.charAt(i));
        }
        return str.toString();
    }
}