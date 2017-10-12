package com;

/**
 * Created by kecso on 3/6/17.
 */
public class A {
    public enum Feature {
        AA,
        BB,
        CC,
//        DD,
//        EE,
        FF
    }

    public static final String[] features;
    static {
        features = new String[Feature.values().length];
        for (int i = 0; i < Feature.values().length; i++) {
            features[i] = Feature.values()[i].name();
        }
    }

    public String[] getFeatures() {
        // TODO Auto-generated method stub
        return features;
    }

    public static int getFeatureIndex(String featureName) {
        for (int i = 0; i < features.length; i++) {
            if (features[i].equalsIgnoreCase(featureName)) {
                return i;
            }
        }
        return -1;
    }

    public static int getFeatureIndexTune2(String featureName) {
        String capitalFeatureName = featureName.toUpperCase();
        for (int i = 0; i < features.length; i++) {
            if (features[i].equals(capitalFeatureName)) {
                return i;
            }
        }
        return -1;
    }

    public static int getFeatureIndexTune(String featureName) {
        try {
//            return Feature.valueOf(featureName.toUpperCase()).ordinal();
             Feature.valueOf(featureName.toUpperCase());
            return 1;
        } catch (IllegalArgumentException e) {
            return -1;
        }
    }

    public static void main(String[] args) throws Exception {


//        System.out.println(Feature.valueOf("FF").ordinal());
//        System.out.println("perf test");
//        Long start = System.currentTimeMillis();
//        for (int i = 0; i < 100000000; i++) {
//            getFeatureIndexTune("FF");
//        }
//        System.out.println("getFeatureIndexTune: " + (System.currentTimeMillis() - start));
//
//        start = System.currentTimeMillis();
//        for (int i = 0; i < 100000000; i++) {
//            getFeatureIndexTune2("FF");
//        }
//        System.out.println("getFeatureIndexTune2: " + (System.currentTimeMillis() - start));
//
//        start = System.currentTimeMillis();
//        for (int i = 0; i < 100000000; i++) {
//            getFeatureIndex("FF");
//        }
//        System.out.println("getFeatureIndex: " + (System.currentTimeMillis() - start));

        String rule = "123";
        Long ruleL = Long.parseLong(rule);

        PairTune p1 = new PairTune("aa", 123L);
//        long l1 = (Long)p1.getValue();

        Pair p2 = new Pair("ab", "123");
        String v2 = (String)p2.getValue();

        Long start = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            long l1 = (Long)p1.getValue();
        }
        System.out.println("cast: " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            long l1 = Long.parseLong(p2.getValue());
        }
        System.out.println("cast old: " + (System.currentTimeMillis() - start));
    }
}

class PairTune {
    private String key = null;
    private Object value = null;

    public PairTune(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }
}

class Pair {
    private String key = null;
    private String value = null;

    public Pair(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
