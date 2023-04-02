package JavaPackage;

public class RecursiveSequences {
    public static void main(String[] args) {
        double x = recSeq(1998);
        System.out.println(x);
        System.out.println((double)-1/1997);
    }

    static double recSeq(int x) {
        if (x == 1) {
            return 1;
        } else if (x == 2) {
            return -1;
        } else {
            return ((double)(x - 3)/(x - 1)) * recSeq(x - 2);
        }
    }
}
