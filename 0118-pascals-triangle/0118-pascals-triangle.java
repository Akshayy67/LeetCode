class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result= new ArrayList<>();
        result.add(new ArrayList<>(Arrays.asList(1)));
        for(int i=2;i<=numRows;i++){
            List<Integer> inner = new ArrayList<>();
            for(int j=0;j<i;j++){
                int l=(j==0?0:result.get(result.size()-1).get(j-1));
                int r=(j==(i-1)?0:result.get(result.size()-1).get(j));
                inner.add(l+r);
            }
            result.add(inner);
        }
        return result;
    }
}