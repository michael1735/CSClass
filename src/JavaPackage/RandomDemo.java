package JavaPackage;
import java.util.Random;
public class RandomDemo {
    public static void main(String[] args) {
        Random rnd = new Random();
        // Ĭ��ʹ�õ�ǰϵͳ�ĺ�������Ϊ����
        double d1 = rnd.nextDouble(); // [0, 1.0)�����С��
        double d2 = rnd.nextDouble() * 7; // [0, 7.0)С��
        float f1 = rnd.nextFloat(); // [0, 1.0)float
        double gaussianFloatingPoint = rnd.nextGaussian();
        // Returns the next pseudorandom, Gaussian ("normally")
        // distributed double value with mean 0.0 and standard deviation 1.0
        // from this random number generator's sequence.
        System.out.println(gaussianFloatingPoint);
        int i1 = rnd.nextInt(); // α�����, 2^32�����е�int value���������
        int i2 = rnd.nextInt(10); // [0, 10)int
        int i3 = rnd.nextInt(18) - 3; // [-3, 15)int
        long l1 = rnd.nextLong(); // �����������������
        boolean b1 = rnd.nextBoolean(); // ���1��boolean
        System.out.println(d1);
        System.out.println(d2);
        System.out.println(f1);
        System.out.println(i1);
        System.out.println(i2);
        System.out.println(i3);
        System.out.println(l1);
        System.out.println(b1);

        // ʹ��Math.random()����
        // �޲�, ����[0, 1.0)��double���������
        // �ԼӴ���Ϳ���ʵ�ַ������ⷶΧ�������
        int min = 2; // �������Сֵ
        int max = 102; // ��������ֵ
        // ����һ��2~100����
        int s = (int) min + (int) (Math.random() * (max - min));
        if (s % 2 == 0) {
            // ż����ֱ�����
            System.out.println("�������: " + s);
        } else {
            // �����ͼ�һ�����
            System.out.println("�������: " + s+1);
        }
        // (int) m + (int) (Math.random()*n) ���Ի�ȡm~m+n���������
    }
}
