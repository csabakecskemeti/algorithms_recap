package randomTrip.inheritance;

/**
 * Created by kecso on 2/27/18.
 */
abstract class AbstractPrinter implements Printer {
    public void print(){
        System.out.println("this is AbstractPrinter");
        Printer.super.print();
    };
}
