package com.ds;

import java.util.Arrays;

/**
 * Created by kecso on 2/2/17.
 */
public class DynamicArray<T> {
    Object[] data;
    int size;
    public DynamicArray() {
        size = 0;
        data = new Object[1];
    }
    public int getSize() {
        return data.length;
    }

    public T get(int idx) {
        return (T) data[idx];
    }

    public void put(Object element) {
        ensureCapacicty(size + 1);
        data[size++] = element;
    }

    public void ensureCapacicty(int minCapacity) {
        int oldCapacity = data.length;
        if (minCapacity > oldCapacity) {
            int newCapacity = oldCapacity * 2;
            // why is this if?
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            data = Arrays.copyOf(data, newCapacity);
        }
    }
}
