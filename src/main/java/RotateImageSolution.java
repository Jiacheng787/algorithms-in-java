/**
 * Leetcode 48 旋转图像
 * https://leetcode-cn.com/problems/rotate-image/
 */
public class RotateImageSolution {
    // 如果学过线性代数，这道题的本质就是矩阵变换
    // 旋转二维矩阵的难点在于将行变成列，将列变成行
    // 而只有按对角线对称的操作是可以轻松完成这一点
    // 对称操作之后就很容易发现规律了
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 先沿对角线镜像对称二维矩阵
        for (int i=0; i<n; i++) {
            for (int j=i; j<n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 然后反转二维矩阵的每一行
        for (int[] row : matrix) {
            this.reverse(row);
        }
    }

    // 反转一维数组
    private void reverse(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (j > i) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public void print(int[][] matrix) {
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[i].length; j++) {
                System.out.print(matrix[i][j] + (j == 2 ? "\n" : ""));
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        RotateImageSolution rotateImageSolution = new RotateImageSolution();
        rotateImageSolution.print(matrix);
        rotateImageSolution.rotate(matrix);
        rotateImageSolution.print(matrix);
    }
}
