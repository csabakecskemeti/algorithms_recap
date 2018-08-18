import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by kecso on 11/8/17.
 */
public class JsonDemo {

    public static void main(String[] args) {
        System.out.println("aaa");
        Set<Long> set = new HashSet<Long>(){{
            add(1L);
            add(2L);
        }};
//        set.stream().forEach(x -> {
//            System.out.println(x);
//        });
//        System.out.println(set.stream().forEach(Collectors.toList());
        String json = "{\"glossary\":{\"title\":\"example glossary\",\"GlossDiv\":{\"title\":\"S\",\"GlossList\":{\"GlossEntry\":{\"ID\":\"SGML\",\"SortAs\":\"SGML\",\"GlossTerm\":\"Standard Generalized Markup Language\",\"Acronym\":\"SGML\",\"Abbrev\":\"ISO 8879:1986\",\"GlossDef\":{\"para\":\"A meta-markup language, used to create markup languages such as DocBook.\",\"GlossSeeAlso\":[\"GML\",\"XML\"]},\"GlossSee\":\"markup\"}}}}}";
        JsonObject jsonObject = new Gson().fromJson(json, JsonObject.class);
        System.out.println(jsonObject.has("title"));

        Set<String> keys = new HashSet<>();
        Queue<JsonElement> jsonElemetQueue = new LinkedList<>();
        jsonElemetQueue.add(jsonObject);
        while (!jsonElemetQueue.isEmpty()) {
            JsonElement current = jsonElemetQueue.poll();
            if (current.isJsonObject()) {
                Set<String> currKeys = ((JsonObject) current).keySet();
                keys.addAll(currKeys);
                for (String key : currKeys) {
                    jsonElemetQueue.offer(((JsonObject) current).get(key));
                }
            } else if (current.isJsonArray()) {
                for (JsonElement je: (JsonArray) current) {
                    jsonElemetQueue.offer(je);
                }
            } else if (current.isJsonPrimitive()) {
                System.out.println(current.toString());
            }
            }
//        Queue<JsonObject> jos = new LinkedList<>();
//        jos.add(jsonObject);
//        while( !jos.isEmpty() ) {
//            JsonObject current = jos.poll();
//            Set<String> currKeys = current.keySet();
//            keys.addAll(currKeys);
//            for (String key: currKeys) {
//                JsonElement jsonElement = current.get(key);
//                if (jsonElement.isJsonObject()) {
//                    jos.offer((JsonObject)jsonElement);
//                }
//            }
//        }
        System.out.println(keys.toString());
    }
}
