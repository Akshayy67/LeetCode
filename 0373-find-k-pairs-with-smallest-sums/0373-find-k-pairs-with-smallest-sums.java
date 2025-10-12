class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->a[0]-b[0]);
        Set<String> st= new HashSet<>();
        pq.offer(new int[] {nums1[0]+nums2[0],0,0});
        st.add("0 0");
        List<List<Integer>> result=new ArrayList<>();
        while(result.size()<k){
            int[] cur=pq.poll();
            int i=cur[1];
            int j=cur[2];
            result.add(Arrays.asList(nums1[i],nums2[j]));
            if(i+1<nums1.length && !st.contains((i+1)+" "+j)){
                st.add((i+1)+" "+j);
                pq.offer(new int[] {nums1[i+1]+nums2[j],i+1,j});
            }
            if(j+1<nums2.length && !st.contains(i+" "+(j+1))){
                st.add(i+" "+(j+1));
                pq.offer(new int[] {nums1[i]+nums2[j+1],i,j+1});
            }
        }
        return result;
    }
}