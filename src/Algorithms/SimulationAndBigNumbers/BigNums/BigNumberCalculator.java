package Algorithms.SimulationAndBigNumbers.BigNums;

import java.util.Scanner;

/**
 * �������еķ��������Ըĳ�static + ����ֵ�������ǿ������ⲿʹ��
 */
public class BigNumberCalculator {

    /**
     * Length of the arrays of operators inside a BigNumberCalculator
     * Can only be used in loops inside the calculation methods if you use the
     * preset fields to store calculation data
     */
    private static final int LEN = 1004;

    int[] a = new int[LEN];
    int[] b = new int[LEN];
    int[] c = new int[LEN];

    /**
     * initialize a BigNumberCalculator Object, with the three preset fields inside it
     * takes three arrays as parameters, the first two are arrays of two operators
     * @param a The first operator
     * @param b The second operator
     * @param c The resulting array
     */
    public BigNumberCalculator(int[] a, int[] b, int[] c) {
        System.arraycopy(a, 0, this.a, 0, a.length);
        System.arraycopy(b, 0, this.b, 0, b.length);
        System.arraycopy(c, 0, this.c, 0, c.length);
    }

    public BigNumberCalculator() { } // ��Ϊa, b, c�Ѿ���ʼ�������ҾͲ��ٳ�ʼ����

    private void clear(int[] a) {
        for (int i : a) {
            i = 0;
        }
    }

    /*
    �����ַ���ʱ���������λ���ַ����ף��±�С��λ�ã�������ϰ���ϣ��±���С��λ�ô�ŵ������ֵ� ���λ�����洢��ת���ַ�������ô����ԭ�����ڣ�
    ���ֵĳ��ȿ��ܷ����仯��������ϣ��ͬ��Ȩֵλʼ�ձ��ֶ��루���磬ϣ�����еĸ�λ�����±� [0]�����е�ʮλ�����±� [1]��������
    ͬʱ���ӡ������˵�����һ�㶼�Ӹ�λ��ʼ���У�����Сѧ����ʽ���㡫�����ⶼ���ˡ���ת�洢���Գ�ֵ����ɡ�
     */

    /**
     * Reads into an array and this can be changed, return values to the main program
     * or modify the code change the fields in the BigNumberCalculator Object
     * @param a An array
     */
    int[] readReverse(int[] a) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();

        clear(a);

        int len = s.length();
        for (int i = 0; i < len; i++) {
            // ��ת�洢
            a[len - 1 - i] = s.charAt(i) - '0';
        }
        return a; // returns the resulting array
    }

    // ר���ڳ���
    int[] readSeq(int[] a) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();

        clear(a);

        int len = s.length();
        for (int i = 0; i < len; i++) {
            a[i] = s.charAt(i) - '0';
        }

        return a;
    }

    void print(int[] a) {
        int i;
        for (i = LEN - 1; i >= 1;i--) {
            // �����Ҳ�����߼��(��Ϊ���λ����[0])
            // �����������(���λ, �Ӵ˿�ʼ����), �������ѭ��
            if (a[i] != 0) {
                break;
            }
        }
        // �������
        for (; i >= 0; --i) { // �������ʡ��i
            System.out.print(a[i]);
        }
    }
    // �߾��ȼӷ�
    void add(int[] a, int[] b, int[] c) {
        clear(c);

        for (int i = 0; i < LEN - 1; i++) {
            c[i] += a[i] + b[i];

            if (c[i] > 9) {
                c[i+1] += 1;
                c[i] -= 10;
            }
        }
    }

    // �߾��ȼ���
    private int[] sub(int[] a, int[] b, int[] c) {
        clear(c);

        for (int i = 0; i < LEN - 1; i++) {
            c[i] += a[i] - b[i];
            if (c[i] < 0) {
                c[i+1] -= 1;
                c[i] += 10;
            }
        }
        return c;
    }

    int[] subtract(int[] a, int[] b, int[] c) {
        int A, B, C;
        String A1 = "", B1 = "", C1 = "";
        for (int i = a.length - 1; i >= 0; i--) {
            A1 = A1.concat(String.valueOf(a[i]));
        }
        A = Integer.parseInt(A1);

        for (int i = b.length - 1; i >= 0; i--) {
            B1 = B1.concat(String.valueOf(b[i]));
        }
        B = Integer.parseInt(B1);

        for (int i = c.length - 1; i >= 0; i--) {
            C1 = C1.concat(String.valueOf(c[i]));
        }
        C = Integer.parseInt(C1);

        if (A > B)
            return sub(a, b, c);
        else
            return sub(b, a, c);
    }

    // �˷�
    // 1. �߾����� * ������
    // ������ͼ��
    // ��Ȼ��Ҳ�ǳ������ԭ�����������Ҫ�ر��ע���� b �ķ�Χ��
    // ������ 10^9������Ӧ���͵�ȡֵ�Ͻ磩����ͬһ����������ô��Ҫ���ø߾��ȡ������ȳ˷���
    void mul_short(int[] a, int b, int[] c) {
        clear(c);

        for (int i = 0; i < LEN - 1; i++) {
            // ֱ�Ӱ�a�ĵ�iλ������Գ�����������
            c[i] += a[i] * b;

            // �����λ
            if (c[i] >= 10) {
                // c[i] / 10 Ϊ��λ������ֵ
                c[i+1] = c[i] / 10;
                // c[i] % 10 Ϊ��ǰλ���µ�ֵ
                c[i] %= 10;
            }
        }
    }

    // 2. �߾��� * �߾���
    void mul(int[] a, int[] b, int[] c) {
        clear(c);

        // ����ʹ��LEN - 1��ǰ�������ǣ�����ǰ�����õ�����array���ǳ���ΪLEN = 1004��
        for (int i = 0; i < LEN - 1; i++) {
            // ����ֱ�Ӽ������еĴӵ͵��ߵ� i λ����һ�������˽�λ
            // �� i ��ѭ��Ϊ c[i] �������������� p + q = i �� a[p] �� b[q] �ĳ˻�֮��
            // ��������Ч����ֱ�ӽ�����ͼ��������������һ���ģ�ֻ�Ǹ��Ӽ�̵�һ��ʵ�ַ�ʽ
            for (int j = 0; j <= i; j++) {
                c[i] += a[j] * b[i - j];
            }
            if (c[i] >= 10) {
                c[i + 1] += c[i] / 10;
                c[i] %= 10;
            }
        }
    }

    // �߾��ȳ���
    // 1. �߾� / �;���
    // ��������������������������ڳ����ǴӸ�λ��ʼ����
    void divShort(int[] a, int b, int[] c) {
        int lenA = a.length;
        int dividendLeft = 0; // �洢����������ʣ�µı�����
        for (int i = 0; i < lenA; i++) {
            c[i] = (dividendLeft * 10 + a[i]) / b;
            dividendLeft = (dividendLeft * 10 + a[i]) % b;
        }
    }
}
