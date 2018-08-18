import org.apache.avro.Schema;
import org.apache.avro.file.CodecFactory;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.util.Random;

/**
 * Created by kecso on 2/28/18.
 */
class Data {

}

public class DataTest {
    public static void main(String[] args) throws IOException {
        writeCsv();
        writeAvro();
        writeAvroDeflate();
        writeAvroSnappy();
        readAvroDeflate();
    }

    public static void writeCsv() throws IOException {
        try (
                BufferedWriter writer = Files.newBufferedWriter(Paths.get("./target/data.csv"));

                CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                        .withHeader("ID", "Name", "Designation", "Company"));
        ) {
            for (int i = 0; i < 1000000; i++) {
                csvPrinter.printRecord(new Random().nextInt() + "", generateRandomHexToken(16), generateRandomHexToken(16),
                        new Random().nextLong() + "", new Random().nextLong() + "");

            }
            csvPrinter.flush();
        }
    }

    public static void readAvroDeflate() throws IOException {
        Schema schema = new Schema.Parser().parse(new File("./src/main/resources/data.avsc"));
        GenericRecord emp = new GenericData.Record(schema);

        File file = new File("./target/dataDeflate.avro");

        DatumReader<GenericRecord> datumReader = new GenericDatumReader<GenericRecord>(schema);
        DataFileReader<GenericRecord> dataFileReader = new DataFileReader<GenericRecord>(file, datumReader);

        while (dataFileReader.hasNext())
        {
            emp = dataFileReader.next();
            System.out.println(emp);
        }
    }

    public static void writeAvro() throws IOException {
        Schema schema = new Schema.Parser().parse(new File("./src/main/resources/data.avsc"));
        File file = new File("./target/data.avro");
        DatumWriter<GenericRecord> datumWriter = new GenericDatumWriter<GenericRecord>(schema);
        DataFileWriter<GenericRecord> dataFileWriter = new DataFileWriter<GenericRecord>(datumWriter);
        dataFileWriter.create(schema, file);
        for (int i = 0; i < 1000000; i++) {
            GenericRecord d1 = new GenericData.Record(schema);
            d1.put("id", new Random().nextInt());
            d1.put("username", generateRandomHexToken(16));
            d1.put("title", generateRandomHexToken(16));
            d1.put("somelong", new Random().nextLong());
            d1.put("somelong2", new Random().nextLong());
            dataFileWriter.append(d1);
        }
        dataFileWriter.close();
    }

    public static void writeAvroDeflate() throws IOException {
        Schema schema = new Schema.Parser().parse(new File("./src/main/resources//data.avsc"));
        File file = new File("./target/dataDeflate.avro");
        DatumWriter<GenericRecord> datumWriter = new GenericDatumWriter<GenericRecord>(schema);
        DataFileWriter<GenericRecord> dataFileWriter = new DataFileWriter<GenericRecord>(datumWriter);
        dataFileWriter.setCodec(CodecFactory.deflateCodec(6));
        dataFileWriter.create(schema, file);
        for (int i = 0; i < 1000000; i++) {
            GenericRecord d1 = new GenericData.Record(schema);
            d1.put("id", new Random().nextInt());
            d1.put("username", generateRandomHexToken(16));
            d1.put("title", generateRandomHexToken(16));
            d1.put("somelong", new Random().nextLong());
            d1.put("somelong2", new Random().nextLong());
            dataFileWriter.append(d1);
        }
        dataFileWriter.close();
    }

    public static void writeAvroSnappy() throws IOException {
        Schema schema = new Schema.Parser().parse(new File("./src/main/resources//data.avsc"));
        File file = new File("./target/dataSnappy.avro");
        DatumWriter<GenericRecord> datumWriter = new GenericDatumWriter<GenericRecord>(schema);
        DataFileWriter<GenericRecord> dataFileWriter = new DataFileWriter<GenericRecord>(datumWriter);
        dataFileWriter.setCodec(CodecFactory.snappyCodec());
        dataFileWriter.create(schema, file);
        for (int i = 0; i < 1000000; i++) {
            GenericRecord d1 = new GenericData.Record(schema);
            d1.put("id", new Random().nextInt());
            d1.put("username", generateRandomHexToken(16));
            d1.put("title", generateRandomHexToken(16));
            d1.put("somelong", new Random().nextLong());
            d1.put("somelong2", new Random().nextLong());
            dataFileWriter.append(d1);
        }
        dataFileWriter.close();
    }

    public static String generateRandomHexToken(int byteLength) {
        SecureRandom secureRandom = new SecureRandom();
        byte[] token = new byte[byteLength];
        secureRandom.nextBytes(token);
        return new BigInteger(1, token).toString(16); //hex encoding
    }
}
