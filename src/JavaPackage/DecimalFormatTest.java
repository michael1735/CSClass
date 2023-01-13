package JavaPackage;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class DecimalFormatTest {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("###.00"); // ¿´pattern matching
        df.setRoundingMode(RoundingMode.HALF_UP);
        double d = 3.145;
        System.out.println(df.format(d));
    }
    // +BigDecimal
}
