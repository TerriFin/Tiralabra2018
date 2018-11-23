package Tiralabra.domain.DataStructures;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author samisaukkonen
 */
public class QueueTest {
    
    Queue<Integer> queue;
    
    @Before
    public void setUp() {
        queue = new Queue<Integer>(Integer.class);
    }

    @Test
    public void queueStartsEmpty() {
        assertTrue(queue.isEmpty());
    }
    
    @Test
    public void afterAddingSizeIsCorrect() {
        for (int i = 0; i < 100; i++) {
            queue.put(i);
        }
        
        assertEquals(100, queue.getSize());
    }
    
    @Test
    public void afterAddingAndRemovingSizeIsCorrect() {
        for (int i = 0; i < 100; i++) {
            queue.put(i);
        }
        
        for (int i = 0; i < 50; i++) {
            queue.poll();
        }
        
        assertEquals(50, queue.getSize());
    }
    
    @Test
    public void afterRemovingAllIsEmpty() {
        for (int i = 0; i < 30; i++) {
            queue.put(i);
        }
        
        for (int i = 0; i < 30; i++) {
            queue.poll();
        }
        
        assertEquals(0, queue.getSize());
    }
    
    @Test
    public void popsAreInCorrectOrder() {
        for (int i = 0; i < 50; i++) {
            queue.put(i);
        }
        
        for (int i = 0; i < 50; i++) {
            int expected = i;
            int actual = queue.poll();
            
            assertEquals(expected, actual);
        }
    }
}
