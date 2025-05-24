class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result= new ArrayList<>();
        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->Long.compare( (long)nums1[a[0]]+nums2[a[1]],(long)nums1[b[0]]+nums2[b[1]])) ;
        Set<String> st= new HashSet<>();
        st.add("0,0");
        pq.add(new int[] {0,0});
        while(!pq.isEmpty() && result.size()<k){
            int[] cur=pq.poll();
            int i=cur[0],j=cur[1];
            result.add(Arrays.asList(nums1[cur[0]] ,nums2[cur[1]]));
            String t1=(i+1)+","+j;
            if(i+1<nums1.length && !st.contains(t1)){
                st.add(t1);
                pq.add(new int[] {i+1,j});
            }
            t1=(i)+","+(j+1);
            if(j+1<nums2.length && !st.contains(t1)){
                st.add(t1);
                pq.add(new int[] {i,j+1});
            }
        }
        return result;
    }
}