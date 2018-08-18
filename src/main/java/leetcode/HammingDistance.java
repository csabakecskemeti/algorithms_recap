package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kecso on 2/22/18.
 */
public class HammingDistance {
    public static void main(String[] args) {
        System.out.println("Hamming distance");
        int x = 6;
        int y = 8;
        int z = x^y;
        System.out.println(z);
        System.out.println(Integer.toBinaryString(x));
        System.out.println(Integer.toBinaryString(y));
        System.out.println(Integer.toBinaryString(z));
        System.out.println(Integer.bitCount(z));


        Map<Integer, List<Integer>> map = new HashMap<>();
        map.merge(1, new ArrayList<Integer>(){{add(11);}}, (list1, list2) -> {list1.addAll(list2); return list1;});
        map.merge(1, new ArrayList<Integer>(){{add(22);}}, (list1, list2) -> {list1.addAll(list2); return list1;});
        System.out.println(map.toString());

    }

}
