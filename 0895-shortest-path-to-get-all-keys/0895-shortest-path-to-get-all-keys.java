class Solution {
    public int shortestPathAllKeys(String[] grid) {
        int[][] directions={{-1,0},{0,1},{1,0},{0,-1}};
        int count=0;
        int start_i=0,start_j=0,allkeys=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length();j++){
                if(grid[i].charAt(j)=='@'){
                    start_i=i;
                    start_j=j;
                }
                else if(grid[i].charAt(j)-'a' >=0 && grid[i].charAt(j)-'a'<26){
                    allkeys|=(1<<(grid[i].charAt(j)-'a'));
                }
            }
        }
        Queue<int[]> q= new LinkedList<>();
        int steps=0;
        q.add(new int[] {start_i,start_j,0});
        boolean[][][] visited= new boolean[grid.length][grid[0].length()][64];
        visited[start_i][start_j][0]=true;
        // Set<Character> locks= new HashSet<>();
        while(!q.isEmpty()){
            int len=q.size();
            // steps++;
            while(len-->0){
                int[] cur=q.poll();
                int keys=cur[2];
                if(keys==allkeys) return steps;
                for(int[] dir:directions){
                    int ni=cur[0]+dir[0];
                    int nj=cur[1]+dir[1];
                    if(notValid(grid,ni,nj)){
                        continue;
                    }
                    int c=grid[ni].charAt(nj);
                    int newKeys=keys;
                    if(c=='#') continue;
                    if(c>='A' && c<='Z' && (keys&(1<<c-'A'))==0) continue;
                    if(c>='a' && c<='z') newKeys|=(1<<c-'a');
                    if(!visited[ni][nj][newKeys]){
                        visited[ni][nj][newKeys]=true;
                        q.add(new int[] {ni,nj,newKeys});
                    }
                }
            }
            steps++;
        }
        return -1;
    }
    private boolean notValid(String[] grid,int i,int j){
        return i<0 || j<0 || i>=grid.length || j>=grid[0].length();
    }
}