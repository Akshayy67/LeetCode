
class TNode{
    TNode[] children= new TNode[26];
    boolean isEow;
}
class Trie{
    TNode root= new TNode();
    Boolean[] dp;
    public void insert(String s){
        TNode cur=root;
        for(char c:s.toCharArray()){
            int idx=c-'a';
            if(cur.children[idx]==null) cur.children[idx]= new TNode();
            cur=cur.children[idx];
        }
        cur.isEow=true;
    }
    public boolean search(String s){
        dp= new Boolean[s.length()];
        return helper(s,0,root);

    }
    public boolean helper(String s,int i,TNode cur){
        if(i==s.length()) return false;
        if(dp[i]!=null) return dp[i];
        TNode now=cur;
        for(int j=i;j<s.length();j++){
            int idx=s.charAt(j)-'a';
            if(now.children[idx]==null) return dp[i]=false;
            now=now.children[idx];
            if(j+1==s.length() && now.isEow) return true;
            if(now.isEow) if(helper(s,j+1,root)) return true;
        }
        return dp[i]=false;
    }
}
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Trie trie= new Trie();
        for(String word:wordDict) trie.insert(word);
        return trie.search(s);
    }
}