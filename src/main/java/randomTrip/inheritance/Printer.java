package randomTrip.inheritance;

/**
 * Created by kecso on 2/27/18.
 */
public interface Printer {
    int version = 0;

    default public void print() {
        System.out.println("Printer IF - version: " + version);
    }
}
