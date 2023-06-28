package Algorithms.SimulationAndBigNumbers.BigNums;

import java.util.Scanner;

/**
 * 里面所有的方法都可以改成static + 返回值来让他们可以在外部使用
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

    public BigNumberCalculator() { } // 因为a, b, c已经初始化好了我就不再初始化了

    private void clear(int[] a) {
        for (int i : a) {
            i = 0;
        }
    }

    /*
    读入字符串时，数字最高位在字符串首（下标小的位置）。但是习惯上，下标最小的位置存放的是数字的 最低位，即存储反转的字符串。这么做的原因在于，
    数字的长度可能发生变化，但我们希望同样权值位始终保持对齐（例如，希望所有的个位都在下标 [0]，所有的十位都在下标 [1]……）；
    同时，加、减、乘的运算一般都从个位开始进行（回想小学的竖式运算～），这都给了「反转存储」以充分的理由。
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
            // 反转存储
            a[len - 1 - i] = s.charAt(i) - '0';
        }
        return a; // returns the resulting array
    }

    // 专对于除法
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
            // 从最右侧向左边检测(因为最低位存在[0])
            // 如果碰到非零(最高位, 从此开始有数), 跳出检测循环
            if (a[i] != 0) {
                break;
            }
        }
        // 输出数字
        for (; i >= 0; --i) { // 这里可以省略i
            System.out.print(a[i]);
        }
    }
    // 高精度加法
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

    // 高精度减法
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

    // 乘法
    // 1. 高精度数 * 单精度
    // 过程在图里
    // 当然，也是出于这个原因，这个方法需要特别关注乘数 b 的范围。
    // 若它和 10^9（或相应整型的取值上界）属于同一数量级，那么需要慎用高精度—单精度乘法。
    void mul_short(int[] a, int b, int[] c) {
        clear(c);

        for (int i = 0; i < LEN - 1; i++) {
            // 直接把a的第i位数码乘以乘数，加入结果
            c[i] += a[i] * b;

            // 处理进位
            if (c[i] >= 10) {
                // c[i] / 10 为进位的增量值
                c[i+1] = c[i] / 10;
                // c[i] % 10 为当前位留下的值
                c[i] %= 10;
            }
        }
    }

    // 2. 高精度 * 高精度
    void mul(int[] a, int[] b, int[] c) {
        clear(c);

        // 这里使用LEN - 1的前提条件是，我们前面设置的三个array都是长度为LEN = 1004的
        for (int i = 0; i < LEN - 1; i++) {
            // 这里直接计算结果中的从低到高第 i 位，且一并处理了进位
            // 第 i 次循环为 c[i] 加上了所有满足 p + q = i 的 a[p] 与 b[q] 的乘积之和
            // 这样做的效果和直接进行上图的运算最后求和是一样的，只是更加简短的一种实现方式
            for (int j = 0; j <= i; j++) {
                c[i] += a[j] * b[i - j];
            }
            if (c[i] >= 10) {
                c[i + 1] += c[i] / 10;
                c[i] %= 10;
            }
        }
    }

    // 高精度除法
    // 1. 高精 / 低精度
    // 除法和其他三则运算的区别在于除法是从高位开始处理
    void divShort(int[] a, int b, int[] c) {
        int lenA = a.length;
        int dividendLeft = 0; // 存储长除法减完剩下的被除数
        for (int i = 0; i < lenA; i++) {
            c[i] = (dividendLeft * 10 + a[i]) / b;
            dividendLeft = (dividendLeft * 10 + a[i]) % b;
        }
    }
}
