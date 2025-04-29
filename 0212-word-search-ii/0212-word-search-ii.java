class TNode{
    TNode[] children= new TNode[26];
    boolean isEOW;
}
class Trie{
    TNode root= new TNode();
    public void insert(String s){
        TNode cur= root;
        for(char c:s.toCharArray()){
            int idx=c-'a';
            if(cur.children[idx]==null) cur.children[idx]=new TNode();
            cur=cur.children[idx];
        }
        cur.isEOW=true;
    }
    public boolean search(StringBuilder s,Set<String> st){
        boolean flag=true;
        TNode cur=root;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            int idx=c-'a';
            if(cur.children[idx]==null) return false;
            cur=cur.children[idx];
        }
        if(cur.isEOW) st.add(s.toString());
        return true;
    }
}
class Solution {
    Trie trie= new Trie();
    int[][] directions= {{1,0},{0,-1},{-1,0},{0,1}};
    Set<String> result;
    public List<String> findWords(char[][] board, String[] words) {
        result= new HashSet<>();
        int n=board.length,m=board[0].length;
        for(String s:words) trie.insert(s);
        boolean[][] visited= new boolean[n][m];
        StringBuilder path= new StringBuilder();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                visited[i][j]=true;
                path.append(board[i][j]);
                backTrack(board,path,i,j,visited);
                visited[i][j]=false;
                path.setLength(0);
            }
        }
        return new ArrayList<>(result);
    }
    public void backTrack(char[][] board,StringBuilder path,int i,int j,boolean[][] visited){
        if(trie.search(path,result)){
            for(int[] dir:directions){
                int ni=i+dir[0];
                int nj=j+dir[1];
                if(valid(board,ni,nj) && !visited[ni][nj]){
                    visited[ni][nj]=true;
                    path.append(board[ni][nj]);
                    backTrack(board,path,ni,nj,visited);
                    path.setLength(path.length()-1);
                    visited[ni][nj]=false;
                }
            }
        }
    }
    public boolean valid(char[][] board,int i,int j){
        return i>=0 && j>=0 && i<board.length && j<board[0].length;
    }
}