class TNode{
    TNode[] children= new TNode[26];
    boolean isEow;
}
class Trie{
    TNode root= new TNode();
    Boolean[] dp;
    List<String> result;
    public void insert(String s){
        TNode cur=root;
        for(char c:s.toCharArray()){
            int idx=c-'a';
            if(cur.children[idx]==null) cur.children[idx]= new TNode();
            cur=cur.children[idx];
        }
        cur.isEow=true;
    }
    public List<String> search(String s){
        dp= new Boolean[s.length()];
        result= new ArrayList<>();
        helper(s,0,root,new StringBuilder());
        return result;
    }
    public boolean helper(String s,int i,TNode cur,StringBuilder path){
        if(i==s.length()) return true;
        // if(dp[i]!=null) return false;
        TNode now=cur;
        int size=path.length();
        for(int j=i;j<s.length();j++){
            int idx=s.charAt(j)-'a';
            if(now.children[idx]==null) return false;
            now=now.children[idx];
            path.append(s.charAt(j));
            if(now.isEow){
                int len=path.length();
                if(j+1!=s.length()) path.append(" ");
                if(helper(s,j+1,root,path)) result.add(path.toString());
                path.setLength(len);
            }
        }
        path.setLength(size);
        return false;
    }
}   
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Trie trie= new Trie();
        for(String word:wordDict) trie.insert(word);
        // List<String> result = new ArrayList<>();
        return trie.search(s);
    }
}