class Solution {
    int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color) return image;
        fill(image,sr,sc,image[sr][sc]);
        image[sr][sc]=-1;
        for(int i=0;i<image.length;i++){
            for(int j=0;j<image[0].length;j++){
                if(image[i][j]==-1) image[i][j]=color;
            }
        }
        return image;
    }
    public void fill(int[][] image, int i,int j,int color){
        for(int[] dir:directions){
            int ni=dir[0]+i,nj=dir[1]+j;
            if(valid(ni,nj,image) && image[ni][nj]==color){
                image[ni][nj]=-1;
                fill(image,ni,nj,color);
            }
        }
    }
    public boolean valid(int i, int j,int[][] grid){
        return i>=0 && j>=0 && i<grid.length && j<grid[0].length;
    }
}