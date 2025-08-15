class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);  
        ArrayList<int[]> list= new ArrayList<>();
        int[] dummy= intervals[0];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<=dummy[1]){
                dummy[1]=Math.max(dummy[1],intervals[i][1]);
            }
            else{
                list.add(new int[] {dummy[0],dummy[1]});
                dummy=intervals[i];
            }
        }
        list.add(dummy);
        int[][] result= new int[list.size()][2];
        for(int i=0;i<list.size();i++){
            result[i][0]=list.get(i)[0];
            result[i][1]=list.get(i)[1];
        }
        return result;
    }
}


// // 0--[1-3]
// // 1---[2-6] 
// // 2--[8-10]  
// // 3--[15-18]  -i 

// reulslt=[1,6] [8,10]
// [15,18]