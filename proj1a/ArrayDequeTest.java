public class ArrayDequeTest {
    public static void main(String[] args) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(1);
        deque.printDeque();
        deque.removeLast();
        deque.printDeque();
        deque.addLast(2);
        deque.printDeque();
        deque.removeFirst();
        deque.printDeque();
    }
}
