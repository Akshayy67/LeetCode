class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m=mat.length,n=mat[0].length;
        int[] result= new int[m*n];
        int idx=0;
        for(int i=0;i<m;i++){
            int ni=i,nj=0;
            List<Integer> list= new ArrayList<>();
            while(ni>=0 && nj<n){
                list.add(mat[ni][nj]);
                ni--;nj++;
            }
            if(i%2==0) for(int x=0;x<list.size();x++) result[idx++]=list.get(x);
            else for(int x=list.size()-1;x>=0;x--) result[idx++]=list.get(x);
        }
        for(int j=1;j<n;j++){
            int ni=m-1,nj=j;
            List<Integer> list= new ArrayList<>();
            while(ni>=0 && nj<n){
                list.add(mat[ni][nj]);
                ni--;nj++;
            }
            if((m+j-1)%2==0) for(int x=0;x<list.size();x++) result[idx++]=list.get(x);
            else for(int x=list.size()-1;x>=0;x--) result[idx++]=list.get(x);
        }
        return result;
    }
}