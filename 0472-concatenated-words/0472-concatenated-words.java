class TNode{
    TNode[] children= new TNode[26];
    boolean isEOW;
}

class Trie{
    TNode root=new TNode();
    public void insert(String s){
        TNode cur=root;
        for(char c:s.toCharArray()){
            if(cur.children[c-'a']==null) cur.children[c-'a']=new TNode();
            cur=cur.children[c-'a'];
        }
        cur.isEOW=true;
    }
    public boolean canForm(String s,int index,int count){
        TNode cur=root;
        for(int i=index;i<s.length();i++){
            int idx=s.charAt(i)-'a';
            if(cur.children[idx]==null) return false;
            cur=cur.children[idx];
            if(cur.isEOW){
                if(i==s.length()-1) return count>=1;
                if(canForm(s,i+1,count+1)) return true;
            }
        }
        return false;
    }
}
class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Trie trie= new Trie();
        Arrays.sort(words,(a,b)->a.length()-b.length());
        List<String> result= new ArrayList<>();
        for(String word:words){
            if(!word.isEmpty() && trie.canForm(word,0,0)) result.add(word);
            else trie.insert(word);
        }
        // for(String word:words){
        //     if(trie.canForm(word,0,0)) result.add(word);
        // }
        return result;
    }
}