package Tiralabra.domain.DataStructures;

import java.lang.reflect.Array;

/**
 *
 * @author samisaukkonen
 */
public class Stack<T> {

    private Class<T> t;

    private int head;
    private T[] array;
    private int length;

    public Stack(Class<T> t) {
        this.t = t;

        this.head = 0;
        this.array = (T[]) Array.newInstance(this.t, 1);
        this.length = 1;
    }

    public void put(T obj) {
        if (head == length) {
            doubleArraySize();
        }
        
        array[head++] = obj;
    }

    public T pop() {
        head--;
        return array[head];
    }

    public int getSize() {
        return head;
    }

    public boolean isEmpty() {
        return head == 0;
    }

    @Override
    public String toString() {
        String toReturn = "";
        for (int i = 0; i < array.length; i++) {
            if (i != array.length - 1) {
                toReturn = toReturn + array[i] + ", ";
            } else {
                toReturn = toReturn + array[i];
            }
        }

        return toReturn;
    }

    private void doubleArraySize() {
        T[] newArray = (T[]) Array.newInstance(t, length * 2);

        for (int i = 0; i < length; i++) {
            newArray[i] = array[i];
        }
        
        array = newArray;
        length *= 2;
    }
}
