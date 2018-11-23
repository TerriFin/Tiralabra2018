package Tiralabra;

import Tiralabra.domain.DataStructures.Queue;
import Tiralabra.domain.DataStructures.Stack;

/**
 *
 * @author samisaukkonen
 */
public class TestMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>(Integer.class);
        
        for (int i = 0; i < 50; i++) {
            stack.put(i);
        }
        
        for (int i = 0; i < 50; i++) {
            int expected = 50 - i;
            int actual = stack.pop();
            
            System.out.println(expected + ", " + actual);
        }
    }
}
