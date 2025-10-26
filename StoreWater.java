import java.util.*;

public class StoreWater {
  // This is brute force method
  // public static int trap(ArrayList<Integer> height) {
  // int maxWater = 0;

  // // brute force
  // for (int i = 0; i < height.size(); i++) {
  // for (int j = i + 1; j < height.size(); j++) {
  // int ht = Math.min(height.get(i), height.get(j));
  // int width = j - i;
  // int currWater = ht * width;
  // maxWater = Math.max(maxWater, currWater);
  // }
  // }
  // return maxWater;
  // }

  // This is 2 pointer approach going to follow
  public static int trap(ArrayList<Integer> height) {
    int maxWater = 0;
    int lp = 0;
    int rp = height.size() - 1;

    while (lp < rp) {
      // calculate water area
      int ht = Math.min(height.get(lp), height.get(rp));
      int width = rp - lp;
      int currWater = ht * width;
      maxWater = Math.max(maxWater, currWater);

      if (height.get(lp) < height.get(rp)) {
        lp++;
      } else {
        rp--;
      }
    }
    return maxWater;
  }

  public static void main(String[] args) {
    ArrayList<Integer> heights = new ArrayList<>(Arrays.asList(1, 8, 6, 2, 5, 4, 8, 3, 7));
    System.out.println(trap(heights));
  }
}
