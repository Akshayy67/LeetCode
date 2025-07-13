class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int i=0,j=0;
        int result=0;
        while(i<players.length && j<trainers.length){
            while(j<trainers.length && players[i]>trainers[j]){
                j++;
            }
            if(j==trainers.length) break;
            result++;
            i++;
            j++;
        }
        return result;
    }
}