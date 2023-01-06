package JavaPackage;
import java.util.Random;
public class RandomDemo {
    public static void main(String[] args) {
        Random rnd = new Random();
        // 默认使用当前系统的毫秒数作为种子
        double d1 = rnd.nextDouble(); // [0, 1.0)区间的小数
        double d2 = rnd.nextDouble() * 7; // [0, 7.0)小数
        float f1 = rnd.nextFloat(); // [0, 1.0)float
        double gaussianFloatingPoint = rnd.nextGaussian();
        // Returns the next pseudorandom, Gaussian ("normally")
        // distributed double value with mean 0.0 and standard deviation 1.0
        // from this random number generator's sequence.
        System.out.println(gaussianFloatingPoint);
        int i1 = rnd.nextInt(); // 伪随机的, 2^32个所有的int value中随机生成
        int i2 = rnd.nextInt(10); // [0, 10)int
        int i3 = rnd.nextInt(18) - 3; // [-3, 15)int
        long l1 = rnd.nextLong(); // 所有整形中随机生成
        boolean b1 = rnd.nextBoolean(); // 随机1个boolean
        System.out.println(d1);
        System.out.println(d2);
        System.out.println(f1);
        System.out.println(i1);
        System.out.println(i2);
        System.out.println(i3);
        System.out.println(l1);
        System.out.println(b1);

        // 使用Math.random()方法
        // 无参, 返回[0, 1.0)的double类型随机数
        // 稍加处理就可以实现返回任意范围的随机数
        int min = 2; // 随机数最小值
        int max = 102; // 随机数最大值
        // 产生一个2~100的数
        int s = (int) min + (int) (Math.random() * (max - min));
        if (s % 2 == 0) {
            // 偶数就直接输出
            System.out.println("随机数是: " + s);
        } else {
            // 奇数就加一后输出
            System.out.println("随机数是: " + s+1);
        }
        // (int) m + (int) (Math.random()*n) 可以获取m~m+n的随机整数
    }
}
