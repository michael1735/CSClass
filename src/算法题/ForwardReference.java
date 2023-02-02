package À„∑®Ã‚;

public class ForwardReference {
    static {
        x = 10;
//        x++; illegal forward reference
    }
    static int x;

    public static void main(String[] args) {
        x++;
        System.out.println(x);
    }
}
