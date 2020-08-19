public class LinkedListDeque<T> {
    /* data used in the class */
    public int size;           //use "size" to cache the information
    public Node sentinel;      //using circular approach
    private class Node {       //make Node "inner class" to avoid naked data structures
        public T item;
        public Node prev;
        public Node next;
        public Node(T i, Node p, Node n) {
            item = i;
            prev = p;
            next = n;
        }
    }

    /* create an empty linked list deque */
    /* I am having a problem here!!!
    public LinkedListDeque() {
        size = 0;
        sentinel = new Node(null, )
    } */
    /* add item to the first and last of the Deque */
    public void addFirst(T item) {
        size += 1;
        sentinel.next = new Node(item, sentinel, sentinel.next);
    }
    public void addLast(T item) {
        size += 1;
        sentinel.prev = new Node(item, sentinel.prev, sentinel);
    }
    /* test if the Deque is empty */
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
    public void printDeque() {

    }
    /* remove the item from the first and last of the Deque */
    public T removeFirst() {
        Node temp = sentinel.next;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        return temp.item;
    }
    public T removeLast() {
        Node temp = sentinel.prev;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        return temp.item;
    }
    /* get the item specified by index */
    public T get(int index) {
        Node ptr = sentinel.next;
        while (index != 0) {
            ptr = ptr.next;
            index -= 1;
        }
        return ptr.item;
    }
    /*
    public T getRecursive(int index) {

    }
     */
}
