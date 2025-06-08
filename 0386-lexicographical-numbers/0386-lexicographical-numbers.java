class TNode{
    TNode[] children = new TNode[10];
    boolean isEOW;
}
class Trie{
    TNode root= new TNode();
    void insert(int n){
        String s=String.valueOf(n);
        TNode cur= root;
        for(char c:s.toCharArray()){
            int idx=c-'0';
            if(cur.children[idx]==null) cur.children[idx]= new TNode();
            cur=cur.children[idx];
        }
        cur.isEOW=true;
    }
    void get(TNode cur,int num,List<Integer> result){
        if(cur.isEOW) {
            result.add(num);
            // return;
        }
        for(int i=0;i<=9;i++){
            if(cur.children[i]!=null){
                get(cur.children[i],num*10+i,result);
            }
        }
    }
}
class Solution {
    public List<Integer> lexicalOrder(int n) {
        Trie trie= new Trie();
        for(int i=1;i<=n;i++) trie.insert(i);
        List<Integer> result= new ArrayList<>();
        trie.get(trie.root,0,result);
        return result;
    }
}