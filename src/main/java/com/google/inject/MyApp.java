package com.google.inject;

/**
 * Created by kecso on 9/24/17.
 */
public class MyApp {
    private MySingleton singleton;

    @Inject
    public void Comp1(MySingleton singleton) {
        this.singleton = singleton;
    }

    public void printSingletonId() {
        System.out.println(singleton.getId());
    }
}
