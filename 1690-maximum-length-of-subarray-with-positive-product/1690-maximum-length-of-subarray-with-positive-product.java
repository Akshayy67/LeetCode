class Solution {
    public int getMaxLen(int[] nums) {
        return Math.max(helper(nums, 1), helper(nums, -1));
    }

    public int helper(int[] nums, int inc) {
        int n = nums.length;
        int start = (inc == 1) ? 0 : n - 1;
        int end = (inc == 1) ? n : -1;

        int pos = 0, neg = 0, total = 0;

        for (int i = start; i != end; i += inc) {
            if (nums[i] == 0) {
                pos = 0;
                neg = 0;
                continue;
            }

            if (nums[i] > 0) {
                pos++;
                if (neg > 0) neg++;
            } else { // nums[i] < 0
                int temp = pos;
                pos = (neg > 0) ? neg + 1 : 0;
                neg = temp + 1;
            }

            total = Math.max(total, pos);
        }
        return total;
    }
}
