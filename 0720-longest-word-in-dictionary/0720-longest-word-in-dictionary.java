class TNode{
    TNode[] children = new TNode[26];
    boolean isEOW=false;
}
class Trie{
    TNode root= new TNode();
    String result="";
    public void insert(String s){
        TNode cur=root;
        for(char c:s.toCharArray()){
            int idx=c-'a';
            if(cur.children[idx]==null) cur.children[idx]= new TNode();
            cur=cur.children[idx];
        }
        cur.isEOW=true;
    }
    public String get(){
        StringBuilder path= new StringBuilder();
        helper(root,path);
        return result;
    }
    public void helper(TNode cur,StringBuilder path){
        if(path.length()>result.length()){
            result=path.toString();
        }
        for(int i=0;i<26;i++){
            if(cur.children[i]!=null && cur.children[i].isEOW){
                path.append((char)('a'+i));
                helper(cur.children[i],path);
                path.setLength(path.length()-1);
            }
        }
    }
}
class Solution {
    public String longestWord(String[] words) {
        Trie trie= new Trie();
        for(String word:words) trie.insert(word);
        return trie.get();
    }
}