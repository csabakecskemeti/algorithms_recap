package com.google.inject;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Map;
import java.util.Set;

/**
 * Created by kecso on 9/24/17.
 */
public class App {
    public static void main(String[] args) {
        System.out.println("APP");
        System.out.println("inject with binding");
        Injector injector = Guice.createInjector(new AppInjector());

        MyApp c = injector.getInstance(MyApp.class);
        c.printSingletonId();

        System.out.println("inject without binding");
        Injector injector1 = Guice.createInjector();
        OtherApp otherApp = injector1.getInstance(OtherApp.class);
        otherApp.printSingletonId();

        JsonArray rule = new Gson().fromJson("{and:[{dp:{eq: \"kochava\"}},{ai:{eq: \"com.ea.game.starwarscapital_row\"}}]}",JsonObject.class)
                .getAsJsonObject().get("and").getAsJsonArray();
//                .get("dp").getAsJsonObject().get("eq").getAsString();

        System.out.println("\n\n");
        String dp = null;
        String ai = null;
        for (JsonElement object : rule) {
//            object.getAsJsonObject().
//            System.out.println(object.toString());
//            try {
                if (dp == null && object.getAsJsonObject().get("dp") != null) {
                    dp = object.getAsJsonObject().get("dp").getAsJsonObject().get("eq").getAsString();
                }
                if (ai == null && object.getAsJsonObject().get("ai") != null) {
                    ai = object.getAsJsonObject().get("ai").getAsJsonObject().get("eq").getAsString();
                }
//            } catch (NullPointerException e) {
//
//            }
        }
        if (dp != null && ai != null) {
            System.out.println(ai + " " + dp);
        }


        JsonArray rules = new Gson().fromJson("{and:[{dp:{eq: \"kochava\"}},{ai:{eq: \"com.ea.game.starwarscapital_row\"}}]}",JsonObject.class)
                .getAsJsonObject().get("and").getAsJsonArray();

        System.out.println(rules.size());

        String a = null;
        for (int i = 0; i < 2; i++ ) {
            a = i+"";
        }
        System.out.println(">> " + a);
    }

}
