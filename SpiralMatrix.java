public class SpiralMatrix {
  public static void printSpiral(int[][] matrix) {
    if (matrix.length == 0)
      return;

    int top = 0, bottom = matrix.length - 1;
    int left = 0, right = matrix[0].length - 1;

    while (top <= bottom && left <= right) {
      // Print top row
      for (int i = left; i <= right; i++) {
        System.out.print(matrix[top][i] + " ");
      }
      top++;

      // Print right column
      for (int i = top; i <= bottom; i++) {
        System.out.print(matrix[i][right] + " ");
      }
      right--;

      if (top <= bottom) {
        // Print bottom row
        for (int i = right; i >= left; i--) {
          System.out.print(matrix[bottom][i] + " ");
        }
        bottom--;
      }

      if (left <= right) {
        // Print left column
        for (int i = bottom; i >= top; i--) {
          System.out.print(matrix[i][left] + " ");
        }
        left++;
      }
    }
    System.out.println();
  }

  public static void main(String[] args) {
    int[][] matrix = {
        { 1, 2, 3, 4 },
        { 5, 6, 7, 8 },
        { 9, 10, 11, 12 },
        { 13, 14, 15, 16 }

    };
    printSpiral(matrix);
  }
}
