class TNode{
        boolean isEow;
        TNode[] children= new TNode[26];
}
class Trie{
    TNode root=new TNode();
    public void insert(String s){
        TNode cur=root;
        for(char c:s.toCharArray()){
            if(cur.children[c-'a']==null) cur.children[c-'a']=new TNode();
            cur=cur.children[c-'a'];
        }
        cur.isEow=true;
    }
    public List<String> allWithPrefix(String pre){
        List<String> list= new ArrayList<>();
        StringBuilder path = new StringBuilder();
        TNode cur=root;
        for(char c:pre.toCharArray()){
            if(cur.children[c-'a']==null) return new ArrayList<>();
            cur=cur.children[c-'a'];
        }
        path.append(pre);
        helper(list,path,cur);
        return list;
    }
    public void helper(List<String> list,StringBuilder path,TNode cur){
        if(list.size()==3) return;
        if(cur.isEow) list.add(path.toString());
        for(int i=0;i<26;i++){
            if(cur.children[i]!=null){
                path.append((char)('a'+i));
                helper(list,path,cur.children[i]);
                path.setLength(path.length()-1);
            }
        }
    }
}
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie obj= new Trie();
        for(String s:products){
            obj.insert(s);
        }
        List<List<String>> result= new ArrayList<>();
        for(int i=0;i<searchWord.length();i++){
            List<String> temp=obj.allWithPrefix(searchWord.substring(0,i+1));
            result.add(temp);
        }
        return result;
    }
}