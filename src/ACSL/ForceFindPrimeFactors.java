package ACSL;

import java.util.*;

public class ForceFindPrimeFactors {
    // ��Ȼ��ǿ����������, ����ֻ�����һ������һ��
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = 2;
        int m = sc.nextInt();
        ArrayList<Integer> existingFactors = new ArrayList<Integer>();
        while (k <= m) {
            if (k == m) {
                System.out.println(m);
                if (!existingFactors.contains(m))
                    existingFactors.add(m); // ��ֹ����16807����7�ı������߸������˵, �η�
                // �η�����������������жϾͻ����������ͬ����������ȥ
                break;
            } else if (m % k == 0) {
                System.out.println(k + " * ");
                m = m / k; // ��һ�з���һ�������ԭ����������������if��Ļ��ͻᵼ�²����ظ�, ��Ϊmû�и���
                if (!existingFactors.contains(k)) // ����������Ҿͼӵ���¼����
                    existingFactors.add(k);
            } else {
                k++;
            }
        }
        System.out.println(existingFactors);
    }
}
