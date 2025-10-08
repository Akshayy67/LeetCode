class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n=spells.length;
        Arrays.sort(potions);
        int[] result= new int[n];
        for(int i=0;i<n;i++){
            int low=0,high=potions.length-1,mid=0;
            while(low<=high){
                mid=(low+high)/2;
                if((long)potions[mid]*spells[i]<success) low=mid+1;
                else high=mid-1;
            }
            result[i]=potions.length-low;
        }
        return result;
    }
}