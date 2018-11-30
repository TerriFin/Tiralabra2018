package Tiralabra.domain.DataStructures;

import java.util.Random;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author samisaukkonen
 */
public class HeapTest {
    
    Heap<Integer> heap;
    Random random;

    @Before
    public void setUp() {
        heap = new Heap<Integer>(Integer.class);
        random = new Random();
    }
    
    private void addRandomNumbersIntoHeap(int amountOfNumbers, int numberSizeLimit) {
        for (int i = 0; i < amountOfNumbers; i++) {
            heap.add(random.nextInt(numberSizeLimit));
        }
    }

    @Test
    public void heapStartsEmpty() {
        assertTrue(heap.isEmpty());
    }
    
    @Test
    public void afterAddingSizeIsCorrect() {
        addRandomNumbersIntoHeap(10, 5);
        assertEquals(10, heap.getSize());
    }
    
    @Test
    public void numbersAreGivenOffHeapInCorrectOrder() {
        addRandomNumbersIntoHeap(100, 500);
        
        int lastNumber = Integer.MIN_VALUE;
        for (int i = 0; i < 100; i++) {
            int lastPolled = heap.poll();
            assertTrue(lastNumber <= lastPolled);
            lastNumber = lastPolled;
        }
    }
    
    @Test
    public void removingNumbersFromHeapWorks() {
        heap.add(100);
        heap.add(200);
        heap.add(150);
        
        addRandomNumbersIntoHeap(50, 90);
        
        heap.remove(100);
        heap.remove(200);
        
        boolean oneHundredFiftyFound = false;
        while (!heap.isEmpty()) {
            int polled = heap.poll();
            
            if (polled == 100 || polled == 200) {
                assertTrue(false);
            }
            
            if (polled == 150) {
                oneHundredFiftyFound = true;
            }
        }
        
        assertTrue(oneHundredFiftyFound);
    }
}
