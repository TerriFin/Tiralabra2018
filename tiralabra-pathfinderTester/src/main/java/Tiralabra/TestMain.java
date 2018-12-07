package Tiralabra;

import java.util.Stack;
import Tiralabra.domain.DataStructures.CustomStack;
import Tiralabra.domain.DataStructures.Heap;
import Tiralabra.domain.DataStructures.Queue;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Random;

/**
 *
 * @author samisaukkonen
 */
public class TestMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        testStack(new Random());
        System.out.println("");
        testQueue(new Random());
        System.out.println("");
        testHeap(new Random());
    }

    private static void testStack(Random random) {
        long timeBeforeJava = System.currentTimeMillis();

        for (int x = 0; x < 100; x++) {
            Stack<Integer> javaStack = new Stack<>();
            for (int y = 1; y < 100000; y++) {
                if (y % 3 == 0) {
                    javaStack.pop();
                } else {
                    javaStack.add(random.nextInt(1000));
                }
            }
        }

        long timeAfterJava = (System.currentTimeMillis() - timeBeforeJava);

        long timebeforeCustom = System.currentTimeMillis();

        for (int x = 0; x < 100; x++) {
            CustomStack<Integer> customStack = new CustomStack<>(Integer.class);
            for (int y = 1; y < 100000; y++) {
                if (y % 3 == 0) {
                    customStack.poll();
                } else {
                    customStack.add(random.nextInt(1000));
                }
            }
        }

        long timeAfterCustom = (System.currentTimeMillis() - timebeforeCustom);

        System.out.println("Time that it took for this projects implementation stack: " + timeAfterCustom
                + "\nTime that it took for java ready made stack: " + timeAfterJava);
    }

    private static void testQueue(Random random) {
        long timeBeforeJava = System.currentTimeMillis();

        for (int x = 0; x < 100; x++) {
            ArrayDeque<Integer> javaQueue = new ArrayDeque<>();
            for (int y = 1; y < 100000; y++) {
                if (y % 3 == 0) {
                    javaQueue.poll();
                } else {
                    javaQueue.add(random.nextInt(1000));
                }
            }
        }

        long timeAfterJava = (System.currentTimeMillis() - timeBeforeJava);

        long timebeforeCustom = System.currentTimeMillis();

        for (int x = 0; x < 100; x++) {
            Queue<Integer> customQueue = new Queue<>(Integer.class);
            for (int y = 1; y < 100000; y++) {
                if (y % 3 == 0) {
                    customQueue.poll();
                } else {
                    customQueue.put(random.nextInt(1000));
                }
            }
        }

        long timeAfterCustom = (System.currentTimeMillis() - timebeforeCustom);

        System.out.println("Time that it took for this projects implementation queue: " + timeAfterCustom
                + "\nTime that it took for java ready made queue: " + timeAfterJava);
    }

    private static void testHeap(Random random) {
        long timeBeforeJava = System.currentTimeMillis();

        for (int x = 0; x < 100; x++) {
            PriorityQueue<Integer> javaQueue = new PriorityQueue<>();
            for (int y = 1; y < 100000; y++) {
                if (y % 3 == 0) {
                    javaQueue.poll();
                } else {
                    javaQueue.add(random.nextInt(1000));
                }
            }
        }

        long timeAfterJava = (System.currentTimeMillis() - timeBeforeJava);

        long timebeforeCustom = System.currentTimeMillis();

        for (int x = 0; x < 100; x++) {
            Heap<Integer> customHeap = new Heap<>(Integer.class);
            for (int y = 1; y < 100000; y++) {
                if (y % 3 == 0) {
                    customHeap.poll();
                } else {
                    customHeap.add(random.nextInt(1000));
                }
            }
        }

        long timeAfterCustom = (System.currentTimeMillis() - timebeforeCustom);

        System.out.println("Time that it took for this projects implementation heap: " + timeAfterCustom
                + "\nTime that it took for java ready made heap: " + timeAfterJava);
    }
}
