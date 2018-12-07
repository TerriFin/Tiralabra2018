package Tiralabra.domain.DataStructures;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author samisaukkonen
 */
public class StackTest {
    
    CustomStack<Integer> stack;

    @Before
    public void setUp() {
        stack = new CustomStack<Integer>(Integer.class);
    }
    
    @Test
    public void newStackIsEmpty() {
        assertTrue(stack.isEmpty());
    }
    
    @Test
    public void afterAddingSizeIsCorrect() {
        for (int i = 0; i < 100; i++) {
            stack.add(i);
        }
        
        assertEquals(100, stack.getSize());
    }
    
    @Test
    public void afterAddingAndRemovingSizeIsCorrect() {
        for (int i = 0; i < 100; i++) {
            stack.add(i);
        }
        
        for (int i = 0; i < 50; i++) {
            stack.poll();
        }
        
        assertEquals(50, stack.getSize());
    }
    
    @Test
    public void afterRemovingAllIsEmpty() {
        for (int i = 0; i < 30; i++) {
            stack.add(i);
        }
        
        for (int i = 0; i < 30; i++) {
            stack.poll();
        }
        
        assertEquals(0, stack.getSize());
    }
    
    @Test
    public void popsAreInCorrectOrder() {
        for (int i = 0; i < 50; i++) {
            stack.add(i);
        }
        
        for (int i = 0; i < 50; i++) {
            int expected = 49 - i;
            int actual = stack.poll();
            
            assertEquals(expected, actual);
        }
    }
}
