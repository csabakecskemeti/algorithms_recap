/**
 * Created by kecso on 6/28/17.
 */
public class MyObject {
    private int x;

    public MyObject(int x) {
        this.x = x;
    }

    public int getX(){
        return x;
    }
    @Override
    public int hashCode() {
        return 255;
    }
}
