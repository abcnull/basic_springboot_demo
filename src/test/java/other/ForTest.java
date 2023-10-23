package other;

import org.junit.Test;

public class ForTest {
    @Test
    public void func() {
        largestLocal(new int[][]{{9,9,8,1},{5,6,2,6},{8,2,6,4},{6,2,2,2}});
    }

    public int[][] largestLocal(int[][] grid) {
        // 2023/10/13

        /*
        解释：
        1.主要是理解题目意思
        坑点：
        */

        if (grid == null || grid.length < 3 || grid[0] == null || grid[0].length < 3) {
            return null;
        }

        int p = 0;
        int q = 0;
        int[][] arr = new int[grid.length - 2][grid.length - 2];
        for (int i = 0; i < grid.length; i++) {
            if (i == 0 || i == grid.length - 1) {
                continue;
            }
            for (int j = 0; j < grid[0].length; j++) {
                if (j == 0 || j == grid[i].length - 1) {
                    continue;
                }
                arr[p][q] = getMax(i, j, grid);
                q++;
            }
            p++;
            q = 0;
        }

        return arr;
    }

    public int getMax(int i, int j, int[][] grid) {
        int max = grid[i][j];
        if (max < grid[i - 1][j - 1]) {
            max = grid[i - 1][j - 1];
        } else if (max < grid[i - 1][j]) {
            max = grid[i - 1][j];
        } else if (max < grid[i - 1][j + 1]) {
            max = grid[i - 1][j + 1];
        } else if (max < grid[i][j - 1]) {
            max = grid[i][j - 1];
        } else if (max > grid[i][j + 1]) {
            max = grid[i][j + 1];
        } else if (max > grid[i + 1][j - 1]) {
            max = grid[i + 1][j - 1];
        } else if (max > grid[i + 1][j]) {
            max = grid[i + 1][j];
        } else if (max > grid[i + 1][j + 1]) {
            max = grid[i + 1][j + 1];
        }

        return max;
    }

}
