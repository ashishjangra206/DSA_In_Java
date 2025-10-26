import java.util.*;

public class PairSumI {

  public static boolean findPairs(ArrayList<Integer> list, int target) {

    // // Brute force method to find the pair sum
    // for (int i = 0; i < list.size(); i++) {
    // for (int j = i + 1; j < list.size(); j++) {
    // if (list.get(i) + list.get(j) == target) {
    // return true;
    // }
    // }
    // }
    // return false;

    // 2 pointer approarch

    int lp = 0;
    int rp = list.size() - 1;

    while (lp < rp) {
      // case 1:
      if (list.get(lp) + list.get(rp) == target) {
        return true;
      }

      // case 2:
      if (list.get(lp) + list.get(rp) < target) {
        lp++;
      } else {
        rp--;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
    int target = 10;
    System.out.println(findPairs(list, target));
  }
}
