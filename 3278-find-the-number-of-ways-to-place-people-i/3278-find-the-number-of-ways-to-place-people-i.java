class Solution {
    public int numberOfPairs(int[][] points) {
        Set<String> pointSet = new HashSet<>();
        for (int[] p : points) {
            pointSet.add(p[0] + "," + p[1]);
        }

        int result = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;
                if (points[j][0] < points[i][0]) continue;
                if (points[j][1] > points[i][1]) continue;

                boolean valid = true;
                for (int x = points[i][0]; x <= points[j][0]; x++) {
                    for (int y = points[j][1]; y <= points[i][1]; y++) {
                        if (x == points[i][0] && y == points[i][1]) continue;
                        if (x == points[j][0] && y == points[j][1]) continue;
                        if (pointSet.contains(x + "," + y)) {
                            valid = false;
                            break;
                        }
                    }
                    if (!valid) break;
                }
                if (valid) result++;
            }
        }
        return result;
    }
}
