class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String,List<Character>> mp= new HashMap<>();
        for(String s:allowed){
            String key=s.substring(0,2);
            mp.putIfAbsent(key,new ArrayList<>());
            mp.get(key).add(s.charAt(2));
        }
        return helper(bottom,0,mp,new StringBuilder());
    }
    public boolean helper(String bottom,int i,Map<String,List<Character>> mp,StringBuilder path){
        // System.out.println(path);
        if(i==bottom.length()-1) {
            if(bottom.length()==1) return true;
            return helper(new String(path),0,mp,new StringBuilder());
        }
        String key=bottom.substring(i,i+2);
        // System.out.println(key);
        if(!mp.containsKey(key)) return false;
        for(char c:mp.get(key)){
            path.append(c);
            if(helper(bottom,i+1,mp,path)) return true;
            path.setLength(path.length()-1);
        }
        return false;
    }
}