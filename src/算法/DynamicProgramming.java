package 算法;

import com.sun.jdi.VMOutOfMemoryException;

public class DynamicProgramming {
    // 核心是记住解决过的子问题的解

    // 自顶向下的备忘录法
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
        // 如果已经求出了fib(n)的值就直接返回, 否则将求出的值保存在memo备忘录中
        if (n <= 2)
            memo[n] = 1;
        else
            memo[n] = fib(n-1, memo) + fib(n-2, memo);
        return memo[n];
    }

    // 自底向上的动态规划
    /*
    备忘录法还是利用了递归，上面算法不管怎样，计算fib（6）的时候最后还是要计算出fib（1），fib（2），fib（3）…,
    那么何不先计算出fib（1），fib（2），fib（3）…,呢？这也就是动态规划的核心，先计算子问题，再由子问题计算父问题
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

    // 观察参与运算的只有i, i-1, i-2三项, 可以将空间压缩如下
    public static int fibDecSpace(int n) {
        if (n < 1) { // 这里<=还是<没区别, 因为就算是<的话, 因为memo_i赋值为1, for循环因为判断不执行会直接返回1(memo_i)
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
