        //(:?????-------------TLE--------------???:)//
// class Solution {
//     public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
//         int n=startTime.length;
//         int[] gaps= new int[n+1];
//         gaps[0]=startTime[0];
//         gaps[n]=eventTime-endTime[n-1];
//         Map<Integer,List<Integer>> mp= new TreeMap<>(Collections.reverseOrder());
//         mp.put(startTime[0],new ArrayList<>());
//         mp.get(startTime[0]).add(0);
//         mp.putIfAbsent(eventTime-endTime[n-1], new ArrayList<>());
//         mp.get(eventTime-endTime[n-1]).add(n);
//         for(int i=1;i<n;i++){
//             mp.putIfAbsent(startTime[i]-endTime[i-1],new ArrayList<>());
//             mp.get(startTime[i]-endTime[i-1]).add(i);
//             gaps[i]=startTime[i]-endTime[i-1];
//         }
//         // for(int key:mp.keySet()){
//         //     for(int idx:mp.get(key)) System.out.println(key+"  "+idx);
//         // }
//         // for(int num:gaps) System.out.print(num+" ");
//         int result=0;
//         for(int i=0;i<n;i++){
//             int size=endTime[i]-startTime[i];
//             result=Math.max(result,gaps[i]+gaps[i+1]);
//             for(int key:mp.keySet()){
//                 if(key<size) break;
//                 for(int idx:mp.get(key)){
//                     int cur=size+gaps[i]+gaps[i+1];
//                     if(idx==i || idx==i+1){
//                         cur-=size;
//                     }
//                     result=Math.max(result,cur);
//                 }
//             }
//         }
//         return result;
//     }
// }
class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n=startTime.length;
        boolean[] q= new boolean[n];
        for(int i=0,t1=0,t2=0;i<n;i++){
            if(endTime[i]-startTime[i]<=t1){
                q[i]=true;
            }
            t1=Math.max(t1,startTime[i]-(i==0?0:endTime[i-1]));
            if(endTime[n-i-1]-startTime[n-i-1]<=t2){
                q[n-i-1]=true;
            }
            t2=Math.max(t2,(i==0?eventTime:startTime[n-i])-endTime[n-i-1]);
        }
        int result=0;
        for(int i=0;i<n;i++){
            int left=i==0?0:endTime[i-1];
            int right=i==n-1?eventTime:startTime[i+1];
            if(q[i]){
                result=Math.max(result,right-left);
            }
            else{
                result=Math.max(result,right-left-(endTime[i]-startTime[i]));
            }
        }
        return result;
    }
}