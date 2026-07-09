class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list= new ArrayList<>();
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        list.add(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            int last=list.get(list.size()-1)[1];
            if(intervals[i][0]>last){
                list.add(intervals[i]);
                
            }
            else{
                list.get(list.size()-1)[1]=Math.max(intervals[i][1],list.get(list.size()-1)[1]);
            }
        }
        int[][] ans = new int[list.size()][2];
        for(int i=0;i<ans.length;i++){
            ans[i][0]=list.get(i)[0];
            ans[i][1]=list.get(i)[1];
        }
        return ans;
    }
}