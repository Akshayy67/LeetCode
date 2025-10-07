class Solution {
    public int[] avoidFlood(int[] rains) {
        TreeSet<Integer> st= new TreeSet<>();
        Map<Integer,Integer> mp=new HashMap<>();
        int[] result= new int[rains.length];
        for(int i=0;i<rains.length;i++){
            if(rains[i]==0) {
                result[i]=1;
                st.add(i);
            }
            else{
                int lake=rains[i];
                result[i]=-1;
                if(mp.containsKey(rains[i])){
                    int prev = mp.get(lake);
                    Integer day=st.higher(prev);
                    if(day==null) return new int[] {};
                    result[day] = rains[i];
                    st.remove(day);
                }
                mp.put(lake,i);
            }
        }
        // int i=0;
        // for(int num:list) result[num]=1;
        return result;
    }
}