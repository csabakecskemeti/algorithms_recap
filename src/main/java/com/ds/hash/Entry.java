package com.ds.hash;

/**
 * Created by kecso on 2/5/17.
 */
public class Entry {
    int key;
    Object value;
    Entry next;

    public Entry(int key, Object value) {
        this.key = key;
        this.value = value;
        this.next =  null;
    }

    public  Entry() {
        this.next = null;
    }

    public int getKey() {
        return key;
    }

    public Object getValue(){
        return value;
    }
}
