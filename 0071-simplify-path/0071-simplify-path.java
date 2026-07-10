class Solution {
    public String simplifyPath(String path) {
        String[] strs= path.split("/");
        Stack<String> stk= new Stack<>();
        for(String s:strs){
            if(s.equals(".")) continue;
            else if(s.equals("..")){
                if(!stk.isEmpty()) stk.pop();
            }
            else if(s.isEmpty()) continue;
            else stk.push(s);
            System.out.println(s);
        }
        if(stk.isEmpty()) return "/";
        StringBuilder str= new StringBuilder();
        for(String st:stk){
            str.append("/");
            str.append(st);
        }
        return str.toString();
    }
}