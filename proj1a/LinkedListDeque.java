public class LinkedListDeque<T> {
    /* data used in the class
    use "size" to cache the information
    using circular approach
    make Node "inner class" to avoid naked data structures
     */
    private int size;
    private Node sentinel;
    private class Node {
        private T item;
        private Node prev;
        private Node next;
        Node(T i, Node p, Node n) {
            item = i;
            prev = p;
            next = n;
        }
    }

    /* create an empty linked list deque */
    public LinkedListDeque() {
        size = 0;
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }
    /* add item to the first and last of the Deque */
    public void addFirst(T item) {
        size += 1;
        Node originFirst = sentinel.next;
        sentinel.next = new Node(item, sentinel, sentinel.next);
        originFirst.prev = sentinel.next;
    }
    public void addLast(T item) {
        size += 1;
        Node originLast = sentinel.prev;
        sentinel.prev = new Node(item, sentinel.prev, sentinel);
        originLast.next = sentinel.prev;
    }
    /* test if the Deque is empty */
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
    /* print the items in the deque, separated by a space */
    public void printDeque() {
        Node ptr = sentinel.next;
        while (ptr != sentinel) {
            System.out.print(ptr.item + " ");
            ptr = ptr.next;
        }
        System.out.println();
    }
    /* remove the item from the first and last of the Deque */
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        size -= 1;
        Node originFirst = sentinel.next;
        sentinel.next = originFirst.next;
        originFirst.next.prev = sentinel;
        return originFirst.item;
    }
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        size -= 1;
        Node originLast = sentinel.prev;
        sentinel.prev = originLast.prev;
        originLast.prev.next = sentinel;
        return originLast.item;
    }
    /* get the item specified by index, iteratively */
    public T get(int index) {
        Node ptr = sentinel.next;
        while (index != 0) {
            ptr = ptr.next;
            index -= 1;
        }
        return ptr.item;
    }
    /* get the item specified by index, recursively */
    public T getRecursive(int index) {
        return getHelper(sentinel.next, index);
    }
    /* private helper method for recursive implementation */
    private T getHelper(Node current, int indices) {
        if (indices == 0) {
            return current.item;
        } else {
            return getHelper(current.next, indices - 1);
        }
    }
}
