class Solution {
    class Trie{
        String node;
        Map<String,Trie> children= new TreeMap<>();
        boolean delete;
    }
    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        Trie root= new Trie();
        for(List<String> path:paths){
            Trie cur=root;
            for(String s:path){
                if(!cur.children.containsKey(s)) {
                    cur.children.put(s, new Trie());
                    cur.children.get(s).node=s;
                }
                cur=cur.children.get(s);
            }
        }
        Map<String,Trie> mp= new HashMap<>();
        identify(root,mp);
        for(Map.Entry<String,Trie> entry:mp.entrySet())
        System.out.println(entry.getKey()+" "+entry.getValue().node);
        List<List<String>> result= new ArrayList<>();
        collect(root,result,new ArrayList<>());
        return result;
    }
    public String identify(Trie root,Map<String,Trie> mp){
        if(root.children.isEmpty()) return "";
        StringBuilder str= new StringBuilder();
        for(Map.Entry<String,Trie> entry:root.children.entrySet()){
            String temp=identify(entry.getValue(),mp);
            str.append(entry.getKey()).append("(").append(temp).append(")");
        }
        String serial= str.toString();
            if(mp.containsKey(serial)){
                mp.get(serial).delete=true;
                root.delete=true;
            }
            else{
                mp.put(serial,root);
            }
        return serial;
    }
    public void collect(Trie root,List<List<String>> list,List<String> path){
        for(Map.Entry<String,Trie> entry:root.children.entrySet()){
            Trie child=entry.getValue();
            if(child.delete) continue;
            path.add(entry.getKey());
            list.add(new ArrayList<>(path));
            collect(child,list,path);
            path.remove(path.size()-1);
        }
    }
}