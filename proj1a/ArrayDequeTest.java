public class ArrayDequeTest {
    public static void main(String[] args) {
        ArrayDeque<Integer> Deque = new ArrayDeque<>();
        Deque.addFirst(0);
        Deque.addLast(1);
        Deque.removeFirst();
        Deque.removeLast();
        Deque.addLast(4);
        Deque.removeLast();
        Deque.addFirst(6);
        Deque.addFirst(7);
        Deque.get(0);
        Deque.addFirst(9);
        Deque.addFirst(10);
        Deque.addFirst(11);
        Deque.addLast(12);
    }
}
