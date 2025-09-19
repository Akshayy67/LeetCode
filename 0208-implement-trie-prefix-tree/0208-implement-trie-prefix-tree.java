class TNode{
    TNode[] children= new TNode[26];
    boolean isEOW=false;
}
class Trie {
    TNode root;
    public Trie() {
        root= new TNode();
    }
    
    public void insert(String word) {
        TNode cur=root;
        for(char c:word.toCharArray()){
            int idx=c-'a';
            if(cur.children[idx]==null) cur.children[idx]= new TNode();
            cur=cur.children[idx];
        }
        cur.isEOW=true;
    }
    
    public boolean search(String word) {
        TNode cur=root;
        for(char c:word.toCharArray()){
            int idx=c-'a';
            if(cur.children[idx]==null) return false;
            cur=cur.children[idx];
        }
        return cur.isEOW;
    }
    
    public boolean startsWith(String prefix) {
        TNode cur=root;
        for(char c:prefix.toCharArray()){
            int idx=c-'a';
            if(cur.children[idx]==null) return false;
            cur=cur.children[idx];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */