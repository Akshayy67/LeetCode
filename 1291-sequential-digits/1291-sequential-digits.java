class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result= new ArrayList<>();
        for(int i=1;i<=9;i++){
            int num=i;
            if(num>=low && num<=high) result.add(num);
           for(int j=i+1;j<=9;j++){
            num=num*10+j;
            if(num>high) break;
            if(num>=low) result.add(num);
           }
        }
        Collections.sort(result);
        return result;
    }
}