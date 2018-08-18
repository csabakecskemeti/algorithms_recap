import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Datekey {
    
    public static void main(String[] args) throws Exception {
//        if (true) {
//           ex();
//        }
        Gson gson = new GsonBuilder().serializeNulls().create();

        Type listType = new TypeToken<ArrayList<Element>>(){}.getType();
        List<Element> o = new Gson().fromJson("[  {\"timestamp\" : \"2018-05-24T00:00:00.000Z\" , \"result\" : {\"x\" :\"abc\"}}, {\"timestamp\" : \"2018-05-25T00:00:00.000Z\", \"result\" : {\"x\" :\"def\"}} " +
                " ]", listType);

//        List<Element> o = new Gson().fromJson("[ ]", listType);

//        List<Element> o = new Gson().fromJson("[ " +
//                "{\"timestamp\" : \"2018-05-24T00:00:00.000Z\", \"result\" : { \"deal_bid_requests\" : 3126736140}}, " +
//                "{\"timestamp\" : \"2018-05-25T00:00:00.000Z\", \"result\" : { \"deal_bid_requests\" : 4446736140}} " +
//                " ]", listType);
        
//        List<Element> o = gson.fromJson("[{a: 12},{a: 13}]", ArrayList.class);
//        System.out.println(o.size());
//        System.out.println(o.get(0).timestamp);
//        System.out.println(o.get(0).result.rrr);
//        System.out.println("------");
//        JsonParser jp = new JsonParser();
//        JsonObject jsonObject = jp.parse("{a: 12}").getAsJsonObject();
//        System.out.println(jsonObject.get("b").getAsLong());
//        System.out.println("------");
        
        
        
        System.out.println("now datekey ---> " + ChronoUnit.DAYS.between(Instant.EPOCH, ZonedDateTime.now()));
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_ZONED_DATE_TIME;
        String date = "2018-07-06T00:00:00.000Z";
        LocalDate localDate = LocalDate.parse(date, dateTimeFormatter);
        System.out.println(date + " to datekey -> " + localDate.toEpochDay());
//        java.util.Date.from(localDate);
//        List<String> a = new ArrayList<>();
//        List<String> b = new ArrayList<>();
//        List<String> c = new ArrayList<>();
//        
//        a.add("1");
//        a.add("2");
//        b.add("3");
//        b.add("4");
////        Collections.copy(c, a);
//        c.addAll(a);
//        c.addAll(b);
//        
//        System.out.println(a);
//        System.out.println(c);
    }
    
//    public static void ex() throws Exception {
//        throw new Exception("bla");
//    }
}
