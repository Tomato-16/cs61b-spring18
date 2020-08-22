public class ArrayDeque<T> {
    /* data used in the class */
    private int size;
    private T[] items;
    private int first;  // the next item we want to addFirst will be in index first
    private int last;   // the next item we want to addLast will be in index last
    // when first == last, the deque is either empty or full.
    // When it's full, index last is not used, size == item.length-1

    /* constructor method */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        first = 0;
        last = 1;
    }
    /* methods of the class */
    /* add items to the first and last */
    public void addFirst(T item) {
        size += 1;
    }
    public void addLast(T item) {
        items[last] = item;
        last = indexInc(last);
        size += 1;
    }

    /* private helper method to help to calculate the index after increment and
      decrement in the circular array */
    private int indexInc(int i) {
        i += 1;
        if (i == items.length) {
            return 0;
        } else {
            return i;
        }
    }
    private int indexDec(int i) {
        i -= 1;
        if (i == -1) {
            return items.length - 1;
        } else {
            return i;
        }
    }
    /*
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }

    public void printDeque() {
        int p = first;
        while (p != ) {
            p += 1;
        }
    }

    public T removeFirst() {}
    public T removeLast() {}
    public T get(int index) {}
     */
}
