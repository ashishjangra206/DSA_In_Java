import java.util.*;

public class arraylist {

  // public static void swap(ArrayList<Integer> list, int idx1, int idx2) {
  // int temp = list.get(idx1);
  // list.set(idx1, list.get(idx2));
  // list.set(idx2, temp);
  // }

  public static void main(String[] args) {
    ArrayList<ArrayList<Integer>> MainList = new ArrayList<>();
    ArrayList<Integer> list1 = new ArrayList<>();
    list1.add(1);
    list1.add(3);
    list1.add(5);
    list1.add(7);
    list1.add(9);
    MainList.add(list1);

    ArrayList<Integer> list2 = new ArrayList<>();
    list2.add(2);
    list2.add(4);
    list2.add(6);
    list2.add(8);
    list2.add(10);

    MainList.add(list2);

    for (int i = 0; i < MainList.size(); i++) {
      ArrayList<Integer> currList = MainList.get(i);
      for (int j = 0; j < currList.size(); j++) {
        System.out.print(currList.get(j) + " ");
      }
      System.out.println();
    }

    // int idx1 = 1, idx2 = 3;
    // System.out.println("Before swap: " + list);
    // swap(list, idx1, idx2);
    // System.out.println("After swap: " + list);

    // System.out.println("ArrayList: " + list);

    // // Accessing elements
    // String firstElement = list.get(0);
    // System.out.println("First Element: " + firstElement);

    // // Iterating through the list
    // System.out.println("Iterating through the list:");
    // for (String fruit : list) {
    // System.out.println(fruit);
    // }

    // // Removing an element
    // list.remove("Banana");
    // System.out.println("After removing Banana: " + list);

    // // Size of the ArrayList
    // int size = list.size();
    // System.out.println("Size of the ArrayList: " + size);
  }
}