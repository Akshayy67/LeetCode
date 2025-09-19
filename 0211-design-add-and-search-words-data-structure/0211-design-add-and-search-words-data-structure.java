class TNode{
    TNode[] children= new TNode[27];
    boolean isEOW= false;
    boolean isDOT= false;
}
class WordDictionary {
    TNode root;
    public WordDictionary() {
        root= new TNode();
    }
    
    public void addWord(String word) {
        TNode cur=root;
        for(char c:word.toCharArray()){
            int idx=c-'a';
            if(c=='.'){
                cur.isDOT=true;
                cur=cur.children[26];
                continue;
            }
            if(cur.children[idx]==null) cur.children[idx]=new TNode();
            cur=cur.children[idx];
        }
        cur.isEOW=true;
    }
    
    public boolean search(String word) {
        return helper(word,0,root);
    }
    public boolean helper(String word,int i,TNode cur){
        if(i==word.length()) return cur.isEOW;
        if(word.charAt(i)=='.'){
            for(int idx=0;idx<26;idx++){
                if(cur.children[idx]!=null){
                    if(helper(word,i+1,cur.children[idx])) return true;
                }
            }
        }
        else if(cur.children[word.charAt(i)-'a']!=null){
            if(helper(word,i+1,cur.children[word.charAt(i)-'a'])) return true;
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */