class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer,Integer> mp= new HashMap<>();
        int result=0,j=0;
        for(int i=0;i<fruits.length;i++){
            mp.put(fruits[i],mp.getOrDefault(fruits[i],0)+1);
            while(mp.size()==3){
                mp.put(fruits[j],mp.get(fruits[j])-1);
                if(mp.get(fruits[j])==0) mp.remove(fruits[j]);
                j++;
            }
            result=Math.max(result,i-j+1);
        }
        return result;
    }
}