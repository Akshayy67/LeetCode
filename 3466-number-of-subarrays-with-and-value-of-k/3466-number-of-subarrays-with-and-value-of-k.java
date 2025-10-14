class Solution {
    public long countSubarrays(int[] nums, int k) {
        long result=0;
        Map<Integer,Long> prev= new HashMap<>();
        for(int num:nums){
            Map<Integer,Long> cur= new HashMap<>();
            cur.put(num,1L);
            for(int key:prev.keySet()){
                int and=key&num;
                cur.put(and,cur.getOrDefault(and,0L)+prev.get(key));
            }
            prev=cur;
            result+=cur.getOrDefault(k,0L);
        }
        return result;
    }
}