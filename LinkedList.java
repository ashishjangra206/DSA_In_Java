public class LinkedList {

  public static class Node {
    int data;
    Node next;

    Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  public static Node head;
  public static Node tail;
  public static int size;

  // method
  // add first and last
  // remove
  // print
  // Search

  public void addFirst(int data) {

    // step 1: create new node
    Node newNode = new Node(data);
    size++;
    if (head == null) {
      head = tail = newNode;
      return;
    }

    // step 2: newNode next = head
    newNode.next = head;

    // step3 : head = newNode
    head = newNode;
    // printLL();
  }

  public void addLast(int data) {

    // step 1: create new node
    Node newNode = new Node(data);
    size++;
    if (head == null) {
      head = tail = newNode;
      return;
    }

    // step 2: tail.next = newNode
    tail.next = newNode;
    // step3 : tail = newNode
    tail = newNode;
    // printLL();
  }

  public void add(int idx, int data) {
    // add in between
    if (idx == 0) {
      addFirst(data);
      return;
    }
    Node newNode = new Node(data);
    size++;
    Node temp = head;
    int i = 0;
    while (i < idx - 1) {
      temp = temp.next;
      i++;
    }
    newNode.next = temp.next;
    temp.next = newNode;
  }

  public int removeFirst() {
    if (size == 0) {
      System.out.println("LL is empty");
      return Integer.MIN_VALUE;
    } else if (size == 1) {
      int val = head.data;
      head = tail = null;
      size = 0;
      return val;
    }
    int val = head.data;
    head = head.next;
    size--;
    return val;
  }

  public int removeLast() {
    if (size == 0) {
      System.out.println("LL is Empty");
      return Integer.MIN_VALUE;
    } else if (size == 1) {
      int val = head.data;
      head = tail = null;
      size = 0;
      return val;
    }

    Node prev = head;
    for (int i = 0; i < size - 2; i++) {
      prev = prev.next;
    }

    int val = prev.next.data; // tail.data
    prev.next = null;
    tail = prev;
    size--;
    return val;
  }

  public int itrSearch(int key) {

    Node temp = head;
    int i = 0;

    while (temp != null) {
      if (temp.data == key) { // key found case
        return i;
      }
      temp = temp.next;
      i++;
    }
    // key not found case
    return -1;
  }

  public int helper(Node head, int key) {
    if (head == null) {
      return -1;
    }
    if (head.data == key) {
      return 0;
    }
    int idx = helper(head.next, key);
    if (idx == -1) {
      return -1;
    }
    return idx + 1;

  }

  public int recSearch(int key) {
    return helper(head, key);
  }

  public void reverse() {

    Node prev = null;
    Node curr = tail = head;
    Node next;

    while (curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    head = prev;
  }

  public void deleteNthFromEnd(int n) {
    // Calculate size
    int sz = 0;
    Node temp = head;
    while (temp != null) {
      temp = temp.next;
      sz++;
    }

    if (n == sz) {
      head = head.next; // remove First
      return;
    }

    // sz-n
    int i = 1;
    int iToFind = sz - n;
    Node prev = head;
    while (i < iToFind) {
      prev = prev.next;
      i++;
    }

    prev.next = prev.next.next;
    return;

  }

  public Node findMid(Node head) {
    Node slow = head;
    Node fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next; // +1 jump
      fast = fast.next.next; // +2 jump

    }
    return slow; // slow is my middle Node
  }

  public boolean checkPalindrome() {
    if (head == null || head.next != null) {
      return true;
    }
    // step1: find mid

    Node midNode = findMid(head);

    // step2: reverse 2nd half
    Node prev = null;
    Node curr = midNode;
    Node next;

    while (curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }

    Node right = prev; // right half head
    Node left = head;

    // step3: check left half & right half
    while (right != null) {
      if (left.data != right.data) {
        return false;
      }
      left = left.next;
      right = right.next;
    }
    return true;
  }

  public static boolean isCycle() {
    Node slow = head;
    Node fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next; // +1
      fast = fast.next.next; // +2
      if (slow == fast)
        return true; // cycle exists
    }
    return false; // cycle doesn't exist
  }

  public static void removeCycle() {
    // detect cycle
    Node slow = head;
    Node fast = head;
    boolean cycle = false;

    while (fast != null && fast.next != null) {
      slow = slow.next; // +1
      fast = fast.next.next; // +2
      if (fast == slow) {
        cycle = true;
        break;
      }
    }

    if (cycle == false) {
      return;
    }

    // find meeting point
    slow = head;
    Node prev = null;
    while (slow != fast) {
      prev = fast;
      slow = slow.next;
      fast = fast.next;
    }
    // remove cycle -> last.next = null
    prev.next = null;
  }

  private Node getMid(Node head) {
    Node slow = head;
    Node fast = head.next;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;// mid node
  }

  private Node merge(Node head1, Node head2) {
    Node mergedLL = new Node(-1);
    Node temp = mergedLL;

    while (head1 != null && head2 != null) {
      if (head1.data <= head2.data) {
        temp.next = head1;
        head1 = head1.next;
        temp = temp.next;
      } else {
        temp.next = head2;
        head2 = head2.next;
        temp = temp.next;
      }
    }

    while (head1 != null) {
      temp.next = head1;
      head1 = head1.next;
      temp = temp.next;
    }

    while (head2 != null) {
      temp.next = head2;
      head2 = head2.next;
      temp = temp.next;
    }

    return mergedLL.next;
  }

  public Node mergeSortLL(Node head) {
    if (head == null || head.next == null) {
      return head;
    }
    // find mid
    Node mid = getMid(head);

    // left & right ms
    Node rightHead = mid.next;
    mid.next = null;
    Node newLeft = mergeSortLL(head);
    Node newRight = mergeSortLL(rightHead);
    // merge

    return merge(newLeft, newRight);
  }

  public void zigZag() {
    // find mid
    Node slow = head;
    Node fast = head.next;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    Node mid = slow;

    // reverse 2nd half
    Node curr = mid.next;
    mid.next = null;
    Node prev = null;
    Node next;

    while (curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }

    Node left = head;
    Node right = prev;
    Node nextL, nextR;

    // alt merge - ZigZag merge
    while (left != null && right != null) {
      nextL = left.next;
      left.next = right;
      nextR = right.next;
      right.next = nextL;

      left = nextL;
      right = nextR;
    }
  }

  public void printLL() {

    if (head == null) {
      System.out.println("LL is empty");
    }
    Node temp = head;

    while (temp != null) {
      System.out.print(temp.data + "->");
      temp = temp.next;
    }
    System.out.println();
  }

  public static void main(String[] args) {
    LinkedList ll = new LinkedList();
    ll.addLast(1);
    ll.addLast(2);
    ll.addLast(3);
    ll.addLast(4);
    ll.addLast(5);
    ll.printLL(); // 1->2->3->4->5
    ll.zigZag(); // 1->5->2->4->3
    ll.printLL();

    // head = new Node(1);
    // Node temp = new Node(2);
    // head.next = temp;
    // head.next.next = new Node(3);
    // head.next.next.next = temp; // 1->2->3->2

    // System.out.println(isCycle());
    // removeCycle();
    // System.out.println(isCycle());

  }
}
