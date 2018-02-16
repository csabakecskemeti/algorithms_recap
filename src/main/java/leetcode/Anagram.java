package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by kecso on 2/15/18.
 */
public class Anagram {
    public static void main(String[] args) {
        System.out.println(findAnagrams("abaaaaaaabba", "aab").toString());

    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || p == null || s.length() == 0
                || p.length() == 0 || s.length() < p.length()) {
            return res;
        }

        char[] pc = p.toCharArray();
        int[] hash = new int[256];
        for(char ch : pc) {
            hash[ch]++;
        }

        int left = 0, right = 0, count = p.length();
        while (right < s.length()) {
            //move right everytime, if the character exists in p's hash, decrease the count
            //current hash value >= 1 means the character is existing in p
            System.out.println("---------");
            System.out.println(s.charAt(right));
            if (hash[s.charAt(right++)]-- >= 1) {
                count--;
            }
//            right++;

            //when the count is down to 0, means we found the right anagram
            //then add window's left to result list
            if (count == 0) res.add(left);

            //if we find the window's size equals to p, then we have to move left (narrow the window) to find the new match window
            //++ to reset the hash because we kicked out the left
            //only increase the count if the character is in p
            //the count >= 0 indicate it was original in the hash, cuz it won't go below 0
            if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0) count++;
        }

//        System.out.println(hash.hashCode());
//        char[] sc = s.toCharArray();
//        int ps = pc.length - 1;
//        int ss = sc.length;
//        for(int i = 0; i + ps < ss; i++) {
//            int right = i + ps;
//            System.out.println("----------------");
//            while (right >= i) {
//                System.out.println(sc[right] + "  " +hash[sc[right]]);
//                hash[sc[right]]--;
//                right--;
//            }
//
//            if (right == i && hash) {
//                System.out.println("add");
//                res.add(i);
//            }
//        }
        return res;
    }
}
