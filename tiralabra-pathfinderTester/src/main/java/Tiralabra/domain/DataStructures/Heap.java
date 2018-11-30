package Tiralabra.domain.DataStructures;

import java.lang.reflect.Array;

/**
 *
 * @author samisaukkonen
 * @param <T>
 */
public class Heap<T extends Comparable<T>> {

    private Class<T> t;

    private int head;
    private T[] array;
    private int length;

    public Heap(Class<T> t) {
        this.t = t;

        this.head = 0;
        this.array = (T[]) Array.newInstance(this.t, 1);
        this.length = 1;
    }

    public void add(T obj) {
        if (head == length) {
            doubleArraySize();
        }
        
        array[head] = obj;
        sortUp(head);
        head++;
    }

    public T poll() {
        if (!isEmpty()) {
            T toReturn = array[0];
            array[0] = array[head - 1];
            array[head - 1] = null;
            head--;
            sortDown(0);

            return toReturn;
        }
        
        return null;
    }

    public int getSize() {
        return head;
    }

    public boolean isEmpty() {
        return head == 0;
    }
    
    public boolean remove(T obj) {
        boolean found = false;
        
        for (int i = 0; i < head; i++) {
            if (array[i].equals(obj)) {
                found = true;
                array[i] = array[head - 1];
                array[head - 1] = null;
                head--;
                sortDown(i);
                break;
            } 
        }
            
        return found;
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

    private void swap(int index1, int index2) {
        T first = array[index1];
        T second = array[index2];

        array[index2] = first;
        array[index1] = second;
    }

    private void sortUp(int index) {
        int parentIndex = getParentIndex(index);

        if (parentIndex >= 0) {
            T current = array[index];
            T parent = array[parentIndex];

            if (current.compareTo(parent) < 0) {
                swap(index, parentIndex);
                sortUp(parentIndex);
            }
        }
    }

    private void sortDown(int index) {
        int leftChildIndex = getLeftChildIndex(index);
        int rightChildIndex = getRightChildIndex(index);
        int swapIndex = 0;

        if (leftChildIndex < head) {
            swapIndex = leftChildIndex;

            if (rightChildIndex < head) {
                if (array[rightChildIndex].compareTo(array[leftChildIndex]) < 0) {
                    swapIndex = rightChildIndex;
                }
            }

            if (array[swapIndex].compareTo(array[index]) < 0) {
                swap(swapIndex, index);
                sortDown(swapIndex);
            }
        }
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private int getLeftChildIndex(int index) {
        return (index * 2) + 1;
    }

    private int getRightChildIndex(int index) {
        return (index * 2) + 2;
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