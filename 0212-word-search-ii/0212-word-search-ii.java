class TNode{
    TNode[] children= new TNode[26];
    boolean isEOW=false;
}
class Trie{
    TNode root= new TNode();
    public void insert(String s){
        TNode cur=root;
        for(char c:s.toCharArray()){
            int idx=c-'a';
            if(cur.children[idx]==null) cur.children[idx]=new TNode();
            cur=cur.children[idx];
        }
        cur.isEOW=true;
    }
    public boolean search(String s,Set<String> st){
        TNode cur=root;
        for(char c:s.toCharArray()){
            int idx=c-'a';
            if(cur.children[idx]==null) return false;
            cur=cur.children[idx];
        }
        if(cur.isEOW) st.add(s);
        return true;
    }
}
class Solution {
    int[][] directions= {{-1,0},{0,1},{1,0},{0,-1}};
    Trie trie;
    Set<String> st;
    public List<String> findWords(char[][] board, String[] words) {
        this.trie=new Trie();
        st= new HashSet<>();
        for(String word:words) trie.insert(word);
        int n=board.length,m=board[0].length;
        boolean[][] visited= new boolean[n][m];
        StringBuilder path= new StringBuilder();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                path.append(board[i][j]);
                visited[i][j]=true;
                backTrack(board,visited,i,j,path);
                visited[i][j]=false;
                path.setLength(path.length()-1);
            }
        }
        return new ArrayList<>(st);
    }
    public void backTrack(char[][] board,boolean[][] visited,int i, int j,StringBuilder path){
        if(trie.search(path.toString(),st)){
            for(int[] dir:directions){
                int ni=i+dir[0],nj=j+dir[1];
                if(valid(board,ni,nj) && !visited[ni][nj]){
                    path.append(board[ni][nj]);
                    visited[ni][nj]=true;
                    backTrack(board,visited,ni,nj,path);
                    path.setLength(path.length()-1);
                    visited[ni][nj]=false;
                }
            }
        }
    }
    public boolean valid(char[][] board,int i, int j){
        return i>=0 && j>=0 && i<board.length && j<board[0].length;
    }
}