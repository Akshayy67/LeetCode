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
    public boolean canForm(String s,int index,Map<Integer,Boolean> dp){
        if(dp.containsKey(index)) return dp.get(index);
        TNode cur=root;
        for(int i=index;i<s.length();i++){
            int idx=s.charAt(i)-'a';
            if(cur.children[idx]==null) break;
            cur=cur.children[idx];
            if(cur.isEOW){
                if(i==s.length()-1) return true;
                if(canForm(s,i+1,dp)) {
                    dp.put(index,true);
                    return true;
                }
            }
        }  
        dp.put(index,false);
        return false;
    }
}

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Trie trie= new Trie();
        for(String str:wordDict){
            // if(!str.isEmpty() && trie.canForm(str,0)) continue;
            if(!str.isEmpty())
            trie.insert(str);
        } 
        return trie.canForm(s,0,new HashMap<>());
    }
}