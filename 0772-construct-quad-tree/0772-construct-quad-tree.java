/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        return helper(grid,0,0,grid.length);
    }
    public Node helper(int[][] grid,int i, int j,int len){
        if(isSame(grid,i,j,len)) return new Node(grid[i][j]==0?false:true,true);
        Node node = new Node(grid[i][j]==0,false);
        node.topLeft=helper(grid,i,j,len/2);
        node.topRight=helper(grid,i,j+len/2,len/2);
        node.bottomLeft=helper(grid,i+len/2,j,len/2);
        node.bottomRight=helper(grid,i+len/2,j+len/2,len/2);
        return node;
    }
    public boolean isSame(int[][] grid,int i,int j,int len){
        for(int ni=i;ni<i+len;ni++){
            for(int nj=j;nj<j+len;nj++) if(grid[ni][nj]!=grid[i][j]) return false;
        }
        return true;
    }
}