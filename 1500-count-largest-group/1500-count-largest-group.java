class Solution {
    public int countLargestGroup(int n) {
        Map<Integer,Integer> mp= new HashMap<>();
        for(int i=1;i<=n;i++){
            int sum=findSum(i);
            mp.put(sum,mp.getOrDefault(sum,0)+1);
        }
        int count=0;int max=0;
        for(int key:mp.keySet()){
            if(mp.get(key)==max) count++;
            else if(mp.get(key)>max){
                max=mp.get(key);
                count=1;
            }
        }
        return count;
    }
    public int findSum(int n){
        int sum=0;
        while(n>0){
            sum+=n%10;
            n/=10;
        }
        return sum;
    }
}