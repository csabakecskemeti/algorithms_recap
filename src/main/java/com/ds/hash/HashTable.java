package com.ds.hash;

/**
 * Created by kecso on 2/5/17.
 */
public class HashTable<T> {
    Entry[] arrayHash;
    int size;
    public HashTable(int size) {
        this.size = size;
        arrayHash = new Entry[size];
        for (int i = 0; i < size; i++) {
            arrayHash[i] = new Entry();
        }
    }

    public int getHash(int key) {
        return key%size;
    }

    public void put(int key, Object value) {
        int hashIndex = getHash(key);
        Entry arrayValue = arrayHash[hashIndex];
        Entry newItem = new Entry(key, value);
        if (arrayValue == null) {
            arrayHash[hashIndex] = newItem;
        } else {
            newItem.next = arrayValue.next;
            arrayValue.next = newItem;
        }
    }

    public T get(int key) {
        int hashIndex = getHash(key);
        Entry arrayValue = arrayHash[hashIndex];
        while (arrayValue != null) {
            if (key == arrayValue.getKey()) {
                return (T)arrayValue.getValue();
            } else {
                arrayValue = arrayValue.next;
            }
        }
        return null;
    }
}
