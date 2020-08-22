public class ArrayDeque<T> {
    /* data used in the class */
    private int size;
    private T[] items;
    private int first;  // the next item we want to addFirst will be in index first
    private int last;   // the next item we want to addLast will be in index last
    // when indexInc(first) == last, the deque is either empty
    // when first == last, the deque is full
    // the array at index first and last should not hold any item

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
        if (first == last) {
            resize(2 * items.length);
        }
        items[first] = item;
        first = indexDec(first);
        size += 1;
    }
    public void addLast(T item) {
        if (first == last) {
            resize(2 * items.length);
        }
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
    /* private helper method to resize the array */
    private void resize(int capacity) {
        int pOrigin = indexInc(first);
        int pResize = 1;
        T[] resizedArray = (T[]) new Object[capacity];
        while (pOrigin != last) {
            resizedArray[pResize] = items[pOrigin];
            pOrigin = indexInc(pOrigin);
            pResize += 1;
        }
        items = resizedArray;
        first = 0;
        last = pResize;
    }
    /* print out the items of the deque, separated by a space */
    public void printDeque() {
        int p = indexInc(first);
        while (p != last) {
            System.out.print(items[p] + " ");
            p = indexInc(p);
        }
        System.out.println();
    }
    /*
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }

    public T removeFirst() {}
    public T removeLast() {}
    public T get(int index) {}
     */
}
