class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> mp=  new HashMap<>();
        for(String s:words) mp.put(s,mp.getOrDefault(s,0)+1);  
        PriorityQueue<String> pq = new PriorityQueue<>((a,b)->{
            if(mp.get(a)==mp.get(b)) return b.compareTo(a);
            return mp.get(a)-mp.get(b);
        });
        for(String s:mp.keySet()){
            pq.offer(s);
            if(pq.size()>k) pq.poll();
        }
        List<String> result= new ArrayList<>();
        while(!pq.isEmpty()){
            result.add(0,pq.poll());
        }
        return result;
    }
}