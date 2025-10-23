import java.util.*;

class Pair {
    int i, j, k, steps;
    public Pair(int i, int j, int k, int steps) {
        this.i = i;
        this.j = j;
        this.k = k;
        this.steps = steps;
    }
}

class Solution {
    int[][] directions = {{-1,0}, {0,1}, {1,0}, {0,-1}};
    
    public int shortestPath(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;
        if (n == 1 && m == 1) return 0;

        boolean[][][] visited = new boolean[n][m][k + 1];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0, k, 0));
        visited[0][0][k] = true;

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            for (int[] dir : directions) {
                int ni = cur.i + dir[0];
                int nj = cur.j + dir[1];
                int nk = cur.k;

                if (ni < 0 || nj < 0 || ni >= n || nj >= m) continue;

                if (grid[ni][nj] == 1) nk--; // obstacle
                if (nk < 0) continue;

                if (ni == n - 1 && nj == m - 1) return cur.steps + 1;

                if (!visited[ni][nj][nk]) {
                    visited[ni][nj][nk] = true;
                    q.add(new Pair(ni, nj, nk, cur.steps + 1));
                }
            }
        }

        return -1;
    }
}
