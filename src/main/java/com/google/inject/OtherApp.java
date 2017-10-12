package com.google.inject;

/**
 * Created by kecso on 9/24/17.
 */
public class OtherApp {
    private MySingleton1 singleton;

    @Inject
    public void Comp1(MySingleton1 singleton) {
        this.singleton = singleton;
    }

    public void printSingletonId() {
        System.out.println(singleton.getId());
    }
}
