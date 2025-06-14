package linkedList;

class DoublyNode {
    int val;
    DoublyNode next;
    DoublyNode prev;
    public DoublyNode(int val) {
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}

public class DoublyLinkedList {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        DoublyNode root = new DoublyNode(arr[0]);
        DoublyNode prev = root;
        for (int i = 1; i < arr.length; i++) {
            DoublyNode node = new DoublyNode(arr[i]);
            prev.next = node;
            node.prev = prev;
            prev = prev.next;
        }
        DoublyNode preHead = null;
        while (root != null) {
            System.out.print(root.val + ",");
            preHead = root;
            root = root.next;
        }
        System.out.println();
        while (preHead != null) {
            System.out.print(preHead.val + ",");
            root = preHead;
            preHead = preHead.prev;
        }
        System.out.println();
        System.out.println("Root val :" +root.val);
    }
}
