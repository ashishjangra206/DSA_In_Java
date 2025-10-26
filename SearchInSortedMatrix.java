public class SearchInSortedMatrix {
  public static int[] searchInSortedMatrix(int[][] matrix, int key) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return new int[] { -1, -1 };
    }

    int rows = matrix.length;
    int cols = matrix[0].length;
    int i = 0, j = cols - 1;

    while (i < rows && j >= 0) {
      if (matrix[i][j] == key) {
        return new int[] { i, j };
      } else if (matrix[i][j] > key) {
        j--;
      } else {
        i++;
      }
    }

    return new int[] { -1, -1 }; // Key not found
  }

  public static void main(String[] args) {
    int matrix[][] = { { 10, 20, 30, 40 },
        { 15, 25, 35, 45 },
        { 27, 29, 37, 48 },
        { 32, 33, 39, 50 } };
    int key = 29;
    int[] result = searchInSortedMatrix(matrix, key);
    if (result[0] != -1) {
      System.out.println("Key found at: (" + result[0] + ", " + result[1] + ")");
    } else {
      System.out.println("Key not found in the matrix.");
    }
  }
}
