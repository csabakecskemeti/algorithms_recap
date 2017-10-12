package com.google.inject;

/**
 * Created by kecso on 9/24/17.
 */
public class AppInjector extends AbstractModule {
    @Override
    protected void configure() {
        //bind the service to implementation class
        bind(MySingleton.class).to(MySingleton1.class);
    }
}
