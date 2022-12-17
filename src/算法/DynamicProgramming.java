package �㷨;

import com.sun.jdi.VMOutOfMemoryException;

public class DynamicProgramming {
    // �����Ǽ�ס�������������Ľ�

    // �Զ����µı���¼��
    public static int Fibonacci(int n) {
        if (n <= 0)
            return n;
        int[] memo = new int[n+1];
        for (int i = 0; i <= n; i++) {
            memo[i] = -1;
        }
        return fib(n, memo);
    }

    public static int fib(int n, int[] memo) {
        if (memo[n] != -1)
            return memo[n];
        // ����Ѿ������fib(n)��ֵ��ֱ�ӷ���, ���������ֵ������memo����¼��
        if (n <= 2)
            memo[n] = 1;
        else
            memo[n] = fib(n-1, memo) + fib(n-2, memo);
        return memo[n];
    }

    // �Ե����ϵĶ�̬�滮
    /*
    ����¼�����������˵ݹ飬�����㷨��������������fib��6����ʱ�������Ҫ�����fib��1����fib��2����fib��3����,
    ��ô�β��ȼ����fib��1����fib��2����fib��3����,�أ���Ҳ���Ƕ�̬�滮�ĺ��ģ��ȼ��������⣬������������㸸����
     */
    public static int fibBotToTop(int n) {
        if (n <= 0)
            return n;
        int[] memo = new int[n+1];
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i < n; i++) {
            memo[i] = memo[i-1] + memo[i-2];
        }
        return memo[n];
    }

    // �۲���������ֻ��i, i-1, i-2����, ���Խ��ռ�ѹ������
    public static int fibDecSpace(int n) {
        if (n < 1) { // ����<=����<û����, ��Ϊ������<�Ļ�, ��Ϊmemo_i��ֵΪ1, forѭ����Ϊ�жϲ�ִ�л�ֱ�ӷ���1(memo_i)
            return n;
        }

        int memo_i_2 = 0;
        int memo_i_1 = 1;
        int memo_i = 1;

        for (int i = 2; i <= n; i++) {
            memo_i = memo_i_1 + memo_i_2;
            memo_i_2 = memo_i_1;
            memo_i_1 = memo_i;
        }
        return memo_i;
    }

    public static void main(String[] args) {

        System.out.println(Fibonacci(5));
        System.out.println(fibBotToTop(0));
        System.out.println(fibDecSpace(1));
    }
}
