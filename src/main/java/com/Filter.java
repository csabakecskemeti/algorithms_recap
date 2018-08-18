package com;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.math3.util.Combinations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Filter {
    public static void main(String[] args) {
        Combinations combinations = new Combinations(3, 1);
        Iterator<int[]> iterator = combinations.iterator();
        while (iterator.hasNext()) {
            System.out.println(Arrays.toString(iterator.next()));
        }

        String ss = "abcd";
        System.out.println(ss.substring(0,3));

        System.out.println("filter");

//        String[] filters = {"", null, ""};
        List<String> filters = new ArrayList<>();
        filters.add(null);
        filters.add("1,2 3");
        filters.add("");
        List<String> cols = new ArrayList<>();
        cols.add("device_type_id");
        cols.add("country_id");
        cols.add("xyz");
//        String[] cols = {"device_type_id", "country_id", "xyz"};
//        String[] filters = {};
        System.out.println(genFilter(filters, cols, "deviceCountryExclusion"));
    }

    public static String genFilter( List<String> filters,  List<String> cols, String resCol) {
        StringBuilder filterBuilder = new StringBuilder();
        for (int i = 0; i < filters.size(); i ++) {

            if (!StringUtils.isEmpty(filters.get(i))) {
                if (filterBuilder.toString().isEmpty()) {
                    filterBuilder.append("sum(if(");
                } else {
                    filterBuilder.append(" and ");
                }
                filterBuilder.append(cols.get(i))
                        .append(" not in (")
                        .append(filters.get(i))
                        .append(")");
            }
        }
        if (filterBuilder.toString().isEmpty()) {
            filterBuilder.append(" 0 as ")
                    .append(resCol);
        } else {
            filterBuilder.append("), 1, 0)) as ")
                    .append(resCol);
        }
        return filterBuilder.toString();
    }
}
