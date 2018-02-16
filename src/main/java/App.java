import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by kecso on 2/1/17.
 */
enum Bla {
    Aaaa("aaaa str", 0),
    Bbbb("bbbb str", 1);
    String str;
    int value;

    private Bla(String str, int val) {
        this.str = str;
        this.value = val;
    }
}

public class App {
    public static void main(String[] args) {

        System.out.println(Bla.Aaaa.name());
        System.out.println(Bla.Aaaa.str);

        Map<String, Integer> map = new HashMap<>();
        map.put("a", 10);
        System.out.println(map.get("a"));
        map.merge("a", 12, Integer::sum);
        System.out.println(map.get("a"));

        map.merge("b", 12, Integer::sum);
        System.out.println(map.get("b"));
        System.out.println("=========");

        String s = "1234";

        char c = '3';



        System.out.println(reverse(-2147483412));
        System.out.println(reverse(1534236469));

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


    public static int reverse(int x) {
        int res = 0;
        while (x != 0) {
            if (Math.abs(res) > Integer.MAX_VALUE/10) {
                return 0;
            }
            res *= 10;
            res += x%10;
            x /= 10;
        }
        return res;
    }


}
