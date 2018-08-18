package randomTrip.inheritance;

/**
 * Created by kecso on 2/27/18.
 */
public class PrinterImpl extends AbstractPrinter implements Printer {
    public static void main(String[] args) {
        PrinterImpl p = new PrinterImpl();
        p.print();
    }

    public void print() {
        System.out.println("this is PrinterImpl");
        super.print();
    }
}
