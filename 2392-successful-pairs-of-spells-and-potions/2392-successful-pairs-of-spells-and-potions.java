class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n=spells.length;
        int[] result= new int[n];
        Arrays.sort(potions);
        for(int i=0;i<spells.length;i++){
            int low=0,mid=0,high=potions.length;
            int pos=high;
            while(low<high){
                mid=(low+high)/2;
                if((long)potions[mid]*spells[i]>=success) high=mid;
                else low=mid+1;
            }
            result[i]=potions.length-low;
            
        }
        return result;
    }
}