public class ArrayDequeTest {
    public static void main(String[] args) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < 16; i++) {
            deque.addFirst(i);
        }
        for (int i = 1; i < 16; i++) {
            deque.addLast(i);
        }
        deque.printDeque();
    }
}
