class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        List<Integer> list= new ArrayList<>();
        list.add(startTime[0]);
        int n=startTime.length;
        for(int i=1;i<n;i++){
            list.add(startTime[i]-endTime[i-1]);
        }
        list.add(eventTime-endTime[n-1]);
        int result=0,cur=0;
        for(int i=0;i<list.size();i++){
            cur+=list.get(i);
            if(i>=k+1) cur-=list.get(i-k-1);
            result=Math.max(result,cur);
        }
        return result;
    }
}