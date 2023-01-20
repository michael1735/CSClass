package JavaPackage;

public class JavaAssert {
    // assert ��Ϊ����, �����жϲ������ʽ�Ľ���Ƿ��Ԥ��һ��
    /*
    assert�������÷���

   ��1��asset expression1;

   ��2��asset expression1 : expression2;

    ��һ���÷��ڸղŵ����������Ѿ������ˣ��ڶ����÷�����ʵ����ı��ʽ�����������Զ���һ���쳣������Ϣ�׳���
     */

    /*
    ע�⣬�����е�ʱ�����������assert�ǲ�����Ч�ģ���Ϊ����ʱassert�ǹرյģ���Ҫʹ�ã�������VM���������п�����
    -enableassertions /-ea
     */
    // assert����ֻ�ܲ���ʹ��, ��Ϊ���������, ����ΪҪ�������д򿪲���, ��������
    public static void checkName(String name) {
        assert name != null : "name is empty!";
    }

    public static void main(String[] args) {
        checkName(null); // java -ea JavaAssert.java
        /*
        IDEA������RUN -> Modify Configurations -> Modify Options -> Add VM Options -> Ȼ��Ĵ�Ӧ�ó�������в���
         */

        // �����ϲ�����assert, ���ǿ����ù�������ʵ���书��
        /*
        1. spring����, Assert������
        Assert.notNull(obj, "obj was null")

        2.Objects.requireNonNull()

        3.(from junit)
        Assert.assertNotNull()
         */
    }
}
