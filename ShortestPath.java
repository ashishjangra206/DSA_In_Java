public class ShortestPath {
  public static float findShortestPath(String path) {
    if (path == null || path.isEmpty()) {
      return 0.0f;
    }
    int x = 0, y = 0;

    for (char direction : path.toCharArray()) {
      if (direction == 'W') {
        x--;
      } else if (direction == 'E') {
        x++;
      } else if (direction == 'N') {
        y++;
      } else if (direction == 'S') {
        y--;
      }
    }

    return (float) Math.sqrt(x * x + y * y);
  }

  public static void main(String[] args) {
    String path = "WWWNNESSE";
    System.out.println(findShortestPath(path));
  }
}
