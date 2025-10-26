public class GridWays {

  public static int countWays(int n, int m) {
    if (n == 1 || m == 1) {
      return 1;
    }
    return countWays(n - 1, m) + countWays(n, m - 1);
  }

  public static void main(String[] args) {
    int n = 3, m = 3;
    System.out.println(countWays(n, m));
  }
}