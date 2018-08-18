import org.apache.avro.file.DataFileReader;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericDatumReader;

import java.io.File;
import java.io.IOException;

public class AvroConvert {

    public static void main(String[] args) throws IOException {
        System.out.println("aaa");
        testRead(new File("/Users/kecso/Documents/workspace/grid/functional_tests/yamp-bpi/input/impression/part-r-00000.avro"));
    }

    public static void testRead (File file) throws IOException {
        GenericDatumReader<GenericData.Record> datum = new GenericDatumReader<GenericData.Record>();
        DataFileReader<GenericData.Record> reader = new DataFileReader<GenericData.Record>(file, datum);

        GenericData.Record record = new GenericData.Record(reader.getSchema());
        while (reader.hasNext()) {
            reader.next(record);
//            System.out.println(record.toString());
            System.out.println(record.get("ad_call_time") + "  " +
                    record.get("account_id") + "  " +
                    record.get("order_id") + "  " +
                    record.get("line_id") + "  " +
                    record.get("publisher_id") + "  " +
                    record.get("advertiser_cost") + "  " +
                    record.get("layered_model_ids_bag") + "  " +
                    record.get("experiment_bucket_ids_bag") + "  " +
                    record.get("score_level") + "  " +
                    record.get("line_model_version_id") + "  " +
                    record.get("multi_arm_bit_flag") + "  " +
                    record.get("identity_expanded_by") + "  " +
                    record.get("pred_score") + "  " +
//                    record.get("impressions") + "  " +
//                    record.get("clicks") + "  " +
//                    record.get("actions") + "  " +
                    record.get("tp_output")
            );
        }

        reader.close();
    }
}
