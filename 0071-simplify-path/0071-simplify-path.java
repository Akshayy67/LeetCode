class Solution {
    public String simplifyPath(String path) {
        StringBuilder str= new StringBuilder();
        Stack<String> stk= new Stack<>();
        String[] paths= path.split("/");
        for(String s:paths){
            if(s.isEmpty()) continue;
            if(s.equals("..")){
                if(!stk.isEmpty()) stk.pop();
                continue;
            }
            if(s.equals(".")){
                continue;
            }
            stk.add(s);
        }
        while(!stk.isEmpty()) str.insert(0,"/"+stk.pop());
        if(str.length()==0) str.append("/");
        return  str.toString();
    }
}