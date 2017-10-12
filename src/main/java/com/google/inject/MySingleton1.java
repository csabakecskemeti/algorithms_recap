package com.google.inject;

/**
 * Created by kecso on 9/24/17.
 */
@Singleton
public class MySingleton1 implements MySingleton {

    private int id = 0;

    public void Singleton1(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return this.id;
    }


    @Override
    public void setId(int newId) {
        this.id = newId;
    }
}
