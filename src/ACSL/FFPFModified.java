package ACSL;

import java.util.*;

public class FFPFModified {
    // 仍然是强制找质因数, 但是只会输出一个质数一次
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = 2;
        int m = sc.nextInt();
        ArrayList<Integer> existingFactors = new ArrayList<Integer>();
        while (k <= m) {
            if (k == m) {
                System.out.println(m);
                existingFactors.add(m);
                break;
            } else if (m % k == 0) {
                System.out.println(k + " * ");
                m = m / k; // 这一行放下一行上面的原因是如果放在下面的if里的话就会导致不断重复, 因为m没有更新
                if (!existingFactors.contains(k)) // 如果不存在我就加到记录器里
                    existingFactors.add(k);
            } else {
                k++;
            }
        }
        System.out.println(existingFactors);
    }
}
