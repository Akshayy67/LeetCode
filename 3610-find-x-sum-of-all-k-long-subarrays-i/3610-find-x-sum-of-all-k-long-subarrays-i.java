class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int[] result= new int[nums.length-k+1];
        for(int i=0;i<nums.length-k+1;i++){
            Map<Integer,Integer> mp= new HashMap<>();
            for(int j=i;j<i+k;j++) mp.put(nums[j],mp.getOrDefault(nums[j],0)+1);
            PriorityQueue<Integer> pq= new PriorityQueue<>((a,b)->{
                if (mp.get(a).equals(mp.get(b))) return b - a;
                return mp.get(b)-mp.get(a);
            });
            for(int key:mp.keySet()) pq.offer(key);
            int sum=0,size=pq.size();
            for(int j=0;j<Math.min(x,size);j++){
                int val=pq.poll();
                sum+=val*mp.get(val);
            }
            result[i]=sum;
        }
        return result;
    }
}