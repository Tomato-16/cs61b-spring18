public class ArrayDeque<T> {
    /* data used in the class */
    private int size;
    private T[] items;
    private int first;
    private int last;
    /* the next item we want to addFirst will be in index first
       the next item we want to addLast will be in index last
       when indexInc(first) == last, the deque is either empty
       when first == last, the deque is full
       the array at index first and last should not hold any item
     */

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
        return (i + 1) % items.length;
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
        if (capacity < 2) {
            return;
        }
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

    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
    /* remove the first and last item of the deque */
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        int originFirst = indexInc(first);
        first = indexInc(first);
        size -= 1;
        // to avoid loitering, keep the reference in temp variable
        T temp = items[originFirst];
        items[originFirst] = null;
        if ((float) size / items.length < 0.25) {
            resize(items.length / 2);
        }
        return temp;
    }
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        int originLast = indexDec(last);
        last = indexDec(last);
        size -= 1;
        // to avoid loitering, keep the reference in temp variable
        T temp = items[originLast];
        items[originLast] = null;
        if ((float) size / items.length < 0.25) {
            resize(items.length / 2);
        }
        return temp;
    }

    /* index starts at 0, so the corresponding index in the circular array
    should be (first+index+1) % items.length
     */
    public T get(int index) {
        return items[(first + index + 1) % items.length];
    }
}
