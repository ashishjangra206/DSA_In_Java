import java.util.ArrayList;

public class PairSum2 {
  public static boolean findPairs(ArrayList<Integer> list, int target) {
    int n = list.size();
    int breakPoint = -1;

    // finding the break point
    for (int i = 0; i < n; i++) {
      if (list.get(i) > list.get(i + 1)) {
        breakPoint = i;
        break;
      }
    }

    int lp = breakPoint + 1; // smallest element
    int rp = breakPoint; // largest element

    while (lp != rp) {
      // case 1:
      if (list.get(lp) + list.get(rp) == target) {
        return true;
      }

      // case 2:
      if (list.get(lp) + list.get(rp) < target) {
        lp = (lp + 1) % n;
      } else {
        rp = (n + rp - 1) % n;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>();
    list.add(11);
    list.add(15);
    list.add(6);
    list.add(8);
    list.add(9);
    list.add(10);

    int target = 16;
    System.out.println(findPairs(list, target));

  }
}
