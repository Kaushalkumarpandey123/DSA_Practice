package implementation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LRU_Cache_Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("LRU Cache Implementation.");
        System.out.println("Enter the size of the LRU Cache");

        int size = sc.nextInt();
        LRU_Cache cache = new LRU_Cache(size);
        LRU_Cache_Impl lruCacheImp = new LRU_Cache_Impl();
        performOperation(cache, lruCacheImp);

    }


    private static void performOperation(LRU_Cache cache, LRU_Cache_Impl lruCacheImp) {
        System.out.println("Choose the options.");
        System.out.println("1. For add.");
        System.out.println("2. For get.");
        System.out.println("3. For print.");
        System.out.println("4. For exit.");
        int option = sc.nextInt();
        int key, val;
        switch (option) {
            case 1:
                System.out.println("Enter the key.");
                key = sc.nextInt();
                System.out.println("Enter the val.");
                val = sc.nextInt();
                lruCacheImp.put(cache, key, val);
                break;
            case 2:
                System.out.println("Enter the key.");
                System.out.println(lruCacheImp.get(cache, sc.nextInt()));
                break;
            case 3:
                lruCacheImp.print(cache);
                break;
            case 4:
                System.exit(0);
            default:
                System.out.println("Please choose correct option.");
        }
        performOperation(cache, lruCacheImp);
    }

}

class LRU_Cache_Impl {

    public void put(LRU_Cache cache, int key, int val) {
        if (cache.getMapToStoreNode().containsKey(key)) {
            DoublyLinkedList node = cache.getMapToStoreNode().get(key);
            DoublyLinkedListImpl.deleteNode(node);
            node.val = val;
            DoublyLinkedListImpl.insertOnFirstPos(cache.getHead(), node);
        } else if (cache.getMapToStoreNode().size() < cache.getSize()) {
            DoublyLinkedList node = DoublyLinkedListImpl.createNewNode(key, val);
            cache.getMapToStoreNode().put(key, node);
            DoublyLinkedListImpl.insertOnFirstPos(cache.getHead(), node);
        } else if (!cache.getMapToStoreNode().isEmpty()) {
            DoublyLinkedList node = DoublyLinkedListImpl.createNewNode(key, val);
            DoublyLinkedList lastNode = cache.getTail().prev;
            cache.getMapToStoreNode().remove(lastNode.key);
            DoublyLinkedListImpl.deleteNode(lastNode);
            cache.getMapToStoreNode().put(key, node);
            DoublyLinkedListImpl.insertOnFirstPos(cache.getHead(), node);
        }
    }

    public int get(LRU_Cache cache, int key) {
        if (!cache.getMapToStoreNode().containsKey(key)) {
            return -1;
        }
        DoublyLinkedList node = cache.getMapToStoreNode().get(key);
        DoublyLinkedListImpl.deleteNode(node);
        DoublyLinkedListImpl.insertOnFirstPos(cache.getHead(), node);
        return node.val;
    }

    public void print(LRU_Cache cache) {
        DoublyLinkedList head = cache.getHead();
        DoublyLinkedList temp = head;
        while (temp.next != cache.getTail()) {
            System.out.print(temp.next + ", ");
            temp = temp.next;
        }
        System.out.println();
    }
}

class LRU_Cache {

    private final Map<Integer, DoublyLinkedList> mapToStoreNode;
    private final DoublyLinkedList head;
    private final DoublyLinkedList tail;
    private final int size;

    public LRU_Cache(int size) {
        this.size = size;
        mapToStoreNode = new HashMap<>(size);
        head = DoublyLinkedListImpl.createNewNode(-1, -1);
        tail = DoublyLinkedListImpl.createNewNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public Map<Integer, DoublyLinkedList> getMapToStoreNode() {
        return mapToStoreNode;
    }

    public DoublyLinkedList getHead() {
        return head;
    }

    public DoublyLinkedList getTail() {
        return tail;
    }

    public int getSize() {
        return size;
    }
}

class DoublyLinkedList {
    int key;
    int val;
    DoublyLinkedList next;
    DoublyLinkedList prev;

    public DoublyLinkedList(int key, int val) {
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev = null;
    }

    @Override
    public String toString() {
        return "Node{" + "key=" + key + ", val=" + val + '}';
    }
}

class DoublyLinkedListImpl {

    public static DoublyLinkedList createDoublyLinkedListHead() {
        DoublyLinkedList head = new DoublyLinkedList(-1, -1);
        DoublyLinkedList tail = new DoublyLinkedList(-1, -1);
        head.next = tail;
        tail.prev = head;
        return head;
    }

    public static DoublyLinkedList createNewNode(int key, int val) {
        return new DoublyLinkedList(key, val);
    }

    public static void deleteNode(DoublyLinkedList node) {
        DoublyLinkedList nextNode = node.next;
        DoublyLinkedList preVNode = node.prev;
        preVNode.next = nextNode;
        nextNode.prev = preVNode;
        return;
    }

    public static void insertOnFirstPos(DoublyLinkedList head, DoublyLinkedList node) {
        DoublyLinkedList next = head.next;
        node.prev = head;
        node.next = next;
        next.prev = node;
        head.next = node;
        return;
    }

}

