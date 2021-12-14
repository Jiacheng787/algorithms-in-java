import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode 54 螺旋矩阵
 * https://leetcode-cn.com/problems/spiral-matrix/
 */
public class SpiralOrderSolution {
    // 核心思路是按右、下、左、上的顺序遍历数组，并使用四个变量圈定未遍历元素的边界
    // 随着螺旋遍历，相应的边界会收缩，直到螺旋遍历完整个数组
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int upper_bound = 0, lower_bound = m - 1;
        int left_bound = 0, right_bound = n - 1;
        ArrayList<Integer> res = new ArrayList<>();
        // res.size() == m * n 则遍历完整个数组
        while (res.size() < m * n) {
            if (upper_bound <= lower_bound) {
                // 在顶部从左向右遍历
                for (int j=left_bound; j<=right_bound; j++) {
                    res.add(matrix[upper_bound][j]);
                }
                // 上边界下移
                upper_bound++;
            }

            if (left_bound <= right_bound) {
                // 在右侧从上向下遍历
                for (int i=upper_bound; i<=lower_bound; i++) {
                    res.add(matrix[i][right_bound]);
                }
                // 右边界上移
                right_bound--;
            }

            if (upper_bound <= lower_bound) {
                // 在底部从右向左遍历
                for (int j=right_bound; j>=left_bound; j--) {
                    res.add(matrix[lower_bound][j]);
                }
                // 下边界上移
                lower_bound--;
            }

            if (left_bound <= right_bound) {
                // 在左侧从下向上遍历
                for (int i=lower_bound; i>=upper_bound; i--) {
                    res.add(matrix[i][left_bound]);
                }
                // 左边界右移
                left_bound++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        SpiralOrderSolution spiralOrderSolution = new SpiralOrderSolution();
        List<Integer> res = spiralOrderSolution.spiralOrder(matrix);
        System.out.println(res);
    }
}
