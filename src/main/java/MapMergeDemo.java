import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kecso on 3/5/18.
 */
public class MapMergeDemo {
    public static void main(String[] args) {
        System.out.println("map merge");
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            map.merge(i%2, new ArrayList<Integer>(){{ add(finalI);}}, (list1, list2) -> {list1.addAll(list2); return list1;});
        }
        System.out.println(map.toString());
    }
}
