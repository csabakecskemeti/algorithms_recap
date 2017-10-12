import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by kecso on 2/1/17.
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello");

        HashSet<String> tldSet = new HashSet<String>(
                Arrays.asList("yahoo.com", "likes.com", "answers.com", "yimg.com", "dailymotion.com", "okcupid.com", "meetme.com", "roblox.com", "dailymail.co.uk", "tagged.com"));

        System.out.println(tldSet.size());
        System.out.println(tldSet.contains("likes.com"));

        MyObject a = new MyObject(99);
        System.out.println(a.getX() + "  " + a.hashCode());

        HashMap<Integer, MyObject> hm = new HashMap<>();
        hm.put(a.hashCode(), a);
        System.out.println(hm.get(255).getX());

        for (int i = 0; i < 10; i++) {
            MyObject curr = new MyObject(i);
            hm.put(curr.hashCode(), curr);
        }
        System.out.println(hm.keySet().toString());
        System.out.println(hm.get(255).getX());

        HashSet<MyObject> hashSet = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            MyObject curr = new MyObject(i);
            hashSet.add(curr);
        }

        System.out.println(hashSet.size());
        System.out.println("----");
        Iterator<MyObject> iterator = hashSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().getX());
        }

    }


}
