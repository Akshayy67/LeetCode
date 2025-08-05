class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int result=0;
        // int j=0;
        int[] slots= new int[fruits.length];
        for(int i=0;i<fruits.length;i++){
            for(int j=0;j<fruits.length;j++){
                if(fruits[i]<=baskets[j] && slots[j]==0){
                    slots[j]=1;
                    break;
                }
            }
        }
        for(int num:slots) result+=(num==0?1:0);
        return result;
    }
}