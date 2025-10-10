class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int result=energy[energy.length-1];
        for(int i=energy.length-1;i>=0;i--){
            if(energy.length-i-1>=k) energy[i]+=energy[i+k]; 
            result=Math.max(result,energy[i]);
        }
        return result;
    }
}