package JavaPackage;

public class LogicOperatorDemo {
    public static void main(String[] args) {
        // 1.& �߼���
        // ���߶�Ϊ����������
        System.out.println(true & true); // t
        System.out.println(false & false); // f
        System.out.println(true & false); // f
        System.out.println(false & true); // f
        System.out.println();

        // 2. | �߼���
        // ���߶�Ϊ��, ������Ǽ�
        System.out.println(true | true); // t
        System.out.println(false | false); // f
        System.out.println(true | false); // t
        System.out.println(false | true ); // t
        System.out.println();

        // 3. ^ �߼����
        System.out.println(true ^ true);
        System.out.println(false ^ false);
        System.out.println(true ^ false);
        System.out.println(false ^ true);
        System.out.println();

        // 4. !�߼���
        System.out.println(!true);
        System.out.println(!false);
        System.out.println();

        // 5. && ��·��
        // ������Ϊ������
        // һ��Ϊ�پ�ȫ��
        // ���߼���ʡʱ��Ϳռ�
        System.out.println(true && true);
        System.out.println(true && false);
        System.out.println(false && false);
        System.out.println(false && true);
        System.out.println();

        // 6. || ��·��
        // ������Ϊ�����
        // һ��Ϊ����ȫ��
        // ���߼���ʡ�ռ��ʱ��
        System.out.println(true || true);
        System.out.println(false || false);
        System.out.println(false || true);
        System.out.println(true || false);
        System.out.println();

        // 7. ��·��������ж�·Ч��
        // �����: ����ߵı��ʽ��ȷ�����ս��, �ұߵľͲ����������
        int a = 10;
        int b = 10;
        boolean result = ++a < 5 && ++b < 5;
        System.out.println(result); // false
        System.out.println(a); // 11
        System.out.println(b); // 10
        System.out.println();

        int c = 10;
        int d = 10;
        boolean result1 = ++c < 5 & ++d < 5;
        System.out.println(result1); // false
        System.out.println(c); // 11
        System.out.println(d); // 11

    }
}
