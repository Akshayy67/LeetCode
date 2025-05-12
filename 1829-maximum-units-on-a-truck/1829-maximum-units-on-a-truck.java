class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(a,b)-> b[1]-a[1]);
        int result=0,i=0;
        while(truckSize>0 && i<boxTypes.length){
            result+=(Math.min(boxTypes[i][0],truckSize)*boxTypes[i][1]);
            truckSize-=boxTypes[i][0];
            i++;
        }
        return result;
    }
}