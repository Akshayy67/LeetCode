class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> combinationSum3(int k, int n) {
        result = new ArrayList<>();
        rec(new ArrayList<>(), n, k, 1);
        return result;
    }

    public void rec(List<Integer> path, int sum, int k, int idx) {
        if (sum < 0)
            return;
        if (path.size() == k) {
            if (sum == 0)
                result.add(new ArrayList<>(path));
            return;
        }
        for (int i = idx; i < 10; i++) {
            path.add(i);
            rec(path, sum - i, k, i + 1);
            path.remove(path.size() - 1);
        }
    }
}