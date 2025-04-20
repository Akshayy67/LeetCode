class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer,Integer> mp= new HashMap<>();
        for(int i=0;i<answers.length;i++){
            mp.put(answers[i],mp.getOrDefault(answers[i],0)+1);
        }
        int result=0;
        for(int key:mp.keySet()){
            if(key==0) result+=mp.get(key);
            else if(mp.get(key)>key+1) result+=(Math.ceil(((double)mp.get(key)/(key+1)*1.0))*(key+1));
            else result+=key+1;
        }
        return result;
    }
}