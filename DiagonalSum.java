public class DiagonalSum {
  public static int diagonalSum(int[][] matrix) {
    if (matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }

    int sum = 0;
    int n = matrix.length;

    for (int i = 0; i < n; i++) {
      sum += matrix[i][i]; // Primary diagonal
      if (i != n - i - 1) { // Avoid double counting the middle element in odd-sized matrices
        sum += matrix[i][n - i - 1]; // Secondary diagonal
      }
    }

    return sum;
  }

  public static void main(String[] args) {
    int[][] matrix = {
        { 1, 2, 3 },
        { 4, 5, 6 },
        { 7, 8, 9 }
    };
    System.out.println("Diagonal Sum: " + diagonalSum(matrix)); // Output: Diagonal Sum: 25
  }
}
