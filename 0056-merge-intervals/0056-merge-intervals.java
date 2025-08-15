class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);  
        ArrayList<int[]> list= new ArrayList<>();
        boolean[] visited= new boolean[intervals.length];
        for(int i=0;i<intervals.length;i++){
            if(visited[i]==true){
                continue;
            }
            visited[i]=true;
            for(int j=i+1;j<intervals.length;j++){
                if(visited[j]==true){
                    continue;
                }
                if(intervals[i][1]>=intervals[j][0]){
                    // intervals[i][0]=Math.min(intervals[i][0],intervals[j][0]);
                    intervals[i][1]=Math.max(intervals[i][1],intervals[j][1]);
                    visited[j]=true;
                }
            }
            list.add(intervals[i]);
        }
        int[][] result= new int[list.size()][2];
        for(int i=0;i<list.size();i++){
            result[i][0]=list.get(i)[0];
            result[i][1]=list.get(i)[1];
        }
        return result;
    }
}

// 0--[1-3]-
// 1---[2-6]-i
// 2--[8-10]
// 3--[15-18]  

// 1-max(3,6)

