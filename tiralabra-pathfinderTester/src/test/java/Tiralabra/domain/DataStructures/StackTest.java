package Tiralabra.domain.DataStructures;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author samisaukkonen
 */
public class StackTest {
    
    Stack<Integer> stack;

    @Before
    public void setUp() {
        stack = new Stack<Integer>(Integer.class);
    }
    
    @Test
    public void newStackIsEmpty() {
        assertTrue(stack.isEmpty());
    }
    
    @Test
    public void afterAddingSizeIsCorrect() {
        for (int i = 0; i < 100; i++) {
            stack.put(i);
        }
        
        assertEquals(100, stack.getSize());
    }
    
    @Test
    public void afterAddingAndRemovingSizeIsCorrect() {
        for (int i = 0; i < 100; i++) {
            stack.put(i);
        }
        
        for (int i = 0; i < 50; i++) {
            stack.pop();
        }
        
        assertEquals(50, stack.getSize());
    }
    
    @Test
    public void afterRemovingAllIsEmpty() {
        for (int i = 0; i < 30; i++) {
            stack.put(i);
        }
        
        for (int i = 0; i < 30; i++) {
            stack.pop();
        }
        
        assertEquals(0, stack.getSize());
    }
    
    @Test
    public void popsAreInCorrectOrder() {
        for (int i = 0; i < 50; i++) {
            stack.put(i);
        }
        
        for (int i = 0; i < 50; i++) {
            int expected = 49 - i;
            int actual = stack.pop();
            
            assertEquals(expected, actual);
        }
    }
}
