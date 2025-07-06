class FindSumPairs {
    int[] n1,n2;
    Map<Integer,Integer> mp1= new HashMap<>();
    Map<Integer,Integer> mp2= new HashMap<>();
    public FindSumPairs(int[] nums1, int[] nums2) {
        n1=nums1;
        n2=nums2;
        for(int num:nums1){
            mp1.put(num,mp1.getOrDefault(num,0)+1);
        }
        for(int num:nums2){
            mp2.put(num,mp2.getOrDefault(num,0)+1);
        }
    }
    
    public void add(int index, int val) {
        mp2.put(n2[index],mp2.get(n2[index])-1);
        if(mp2.get(n2[index])==0) mp2.remove(n2[index]);
        n2[index]+=val;
        mp2.put(n2[index],mp2.getOrDefault(n2[index],0)+1);
    }
    
    public int count(int tot) {
        int result=0;
        for(int num:mp1.keySet()){
            if(mp2.containsKey(tot-num)){
                result+=mp1.get(num)*mp2.get(tot-num);
            }
        }
        return result;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */