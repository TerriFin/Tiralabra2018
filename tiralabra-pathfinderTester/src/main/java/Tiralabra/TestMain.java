package Tiralabra;

import Tiralabra.domain.DataStructures.Queue;

/**
 *
 * @author samisaukkonen
 */
public class TestMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<Integer>(Integer.class);
        
        queue.put(1);
        System.out.println(queue);
        
        queue.poll();
        System.out.println(queue);
        
        queue.put(2);
        System.out.println(queue);
        
        queue.poll();
        System.out.println(queue);
        
        queue.put(3);
        System.out.println(queue);
        
        queue.poll();
        System.out.println(queue);
        
        queue.put(4);
        System.out.println(queue);
        
        System.out.println(queue.getSize());
    }
}
