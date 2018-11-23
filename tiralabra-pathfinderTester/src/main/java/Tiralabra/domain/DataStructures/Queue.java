package Tiralabra.domain.DataStructures;

import java.lang.reflect.Array;

/**
 *
 * @author samisaukkonen
 */
public class Queue<T> {
    
    private Class<T> t;

    private int head;
    private int tail;
    private T[] array;
    private int length;
    
    private int size;

    public Queue(Class<T> t) {
        this.t = t;
        
        this.head = 0;
        this.tail = 0;
        this.array = (T[]) Array.newInstance(this.t, 1);
        this.length = 1;
        
        this.size = 0;
    }

    public void put(T obj) {
        if (tail != length && array[tail] != null) {
            doubleArraySize();
        }

        if (tail == length) {
            tail = 0;
            put(obj);
        } else {
            array[tail++] = obj;
            size++;
        }
    }

    public T poll() {
        if (head == length) {
            head = 0;
            return poll();
        } else {
            T toReturn = array[head];
            array[head++] = null;
            size--;
            return toReturn;
        }
    }
    
    public int getSize() {
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
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
        int oldSize = size;
        
        T[] newArray = (T[]) Array.newInstance(t, length * 2);
        
        for (int i = 0; i < length; i++) {
            newArray[i] = poll();
        }
        
        head = 0;
        tail = length;
        array = newArray;
        length *= 2;
        
        size = oldSize;
    }
}
