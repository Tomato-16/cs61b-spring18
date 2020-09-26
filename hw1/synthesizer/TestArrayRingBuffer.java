package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(4);
        arb.enqueue(2);
        arb.enqueue(3);
        arb.enqueue(5);
        arb.enqueue(6);
        assertEquals(2, (int) arb.peek());
        assertTrue(arb.isFull());
        arb.dequeue();
        assertEquals(3, (int) arb.peek());
        arb.dequeue();
        assertEquals(5, (int) arb.peek());
        arb.dequeue();
        assertEquals(6, (int) arb.peek());
        arb.dequeue();
        assertTrue(arb.isEmpty());
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
