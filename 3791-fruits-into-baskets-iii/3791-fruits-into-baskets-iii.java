class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n=fruits.length;
        int m=(int)Math.sqrt(n);
        int[] groups = new int[(int)Math.ceil(n/(double)m)];
        for(int i=0;i<n;i++){
            groups[i/m]=Math.max(groups[i/m],baskets[i]);
        }
        int result=0;
        for(int i=0;i<n;i++){
            int num=fruits[i];
            boolean placed=false;
            for(int j=0;j<groups.length && !placed;j++){
                if(groups[j]<num) continue;
                int choose=0;
                groups[j]=0;
                for(int k=0;k<m;k++){
                    int pos=m*j+k;
                    if(pos<n && baskets[pos]>=num && choose==0){
                        baskets[pos]=0;
                        choose=1;
                        placed=true;
                    }
                    if(pos<n)
                    groups[j]=Math.max(groups[j],baskets[pos]);
                }
                if(placed) break;
            }
            result+=(placed?0:1);
        }
        return result;
    }
}