package JavaPackage.AnnotationsDemo;

import java.util.Map;

/**
 * @author Michael1735
 * @date 2023/2/5 0:03
 * @description predefined annotations in Java
 */
public class PredefinedAnnotation {
    /*
    Predefined in java.lang(that is, used by the java language):
    @Depreciated
    @Override
    @SuppressWarnings
     */

    // @Depreciated annotation
    // Javadoc comment follows
    // Javadoc���annotation�Ͷ�Ӧ�Ĵ��봦annotation���໥��ϵ��, javadoc����Сд����ĸ, Java���ô�д����ĸ
    // ����˵@DepreciatedӦ���ڶ�Ӧ��javadoc�ĵ������@depreciated����ΪɶʧЧ
    /**
     * @deprecated
     * explanation of why it has depreciated
     */
    @Deprecated
    static void depreciatedMethod() {
        System.out.println("this method has depreciated");
    }

    // @Override
    // ���Ԫ����д���䳬���ﶨ���һ������
    @Override
    public String toString() {
        return "this overrides the method in java.lang.Object";
    }
    // @Override���Ա������, ���һ�������Ϊ@Override�ķ�����û����ȷ����д������ķ����������ᱨ��

    // @SuppressWarnings
    // ���ڸ��߱���������ʾ�ض�����
    // ��@SuppressWarnings("depreciation")
    // ���Ԫ�ؿ�����������﷨
    // @SuppressWarnings({"depreciation", "unchecked"})
    /*
    ����: all(����)
    dep-ann(��ע�����@depreciated��صľ���)
    fallthrough(switch��ûbreak)
    incomplete-switch(switch(enum case)����©��Ŀ)
    javadoc(������javadoc��صľ��� nls, �������nls�ִ�������صľ��� null, �������ֵ������صľ���)
    unused(δʹ�ñ���, ����, ��...)
    unchecked(δ�������, �������ڷ��͵�ʹ����)
     */
    @SuppressWarnings({"unchecked", "unused"})
    public void uncheckedTest(Map<String, ?> map) {
        Map<String, String> resultMap = (Map<String, String>) map;
    }
    /*
    ��ʵ������Ҫ��ס��ô��, IDEA�����Զ�����
    ����ݷ���, Try to generify xxx -> suppress for method
    ��������suppress for xxx�����Զ����ɶ�Ӧ��ע��
     */

    /*
    ģ�����������ᱨunchecked����(�緺��), ���
    �������Ա�϶������Ĺ��캯���ͷ��������岻�����varargs����ִ��Ǳ�ڵĲ���ȫ�Ĳ���,
    ��ʹ��@SafeVarargs���б��, �����Ļ�, Java�������Ͳ��ᱨunchecked���档

    @SafeVarargsע��, ֻ�����ڱ�ǹ��캯���ͷ���, ���ڱ�����������ΪRUNTIME, ���Դ�ע�����������ʱ��Ч.
    ֻ������static/final����, ��static/final��@SuppressWarnings("unchecked")
    asserts that the code does not perform potentially unsafe operations on its varargs parameter
     */
    @SafeVarargs
    public static <T> void display(T... array) {
        for (T arg : array) {
            System.out.println(arg.getClass().getName() + " : " + arg);
        }
    }

    public static void main(String[] args) {
        display(10, 20, 30);
        display("10", 20, 30); // ��@SafeVarargs��ѹ���������
    }

    /*
    @FunctionalInterface
    ����ʽ�ӿ�, ֻ����һ�����󷽷��Ľӿ�
    Ҳ��ΪSAM�ӿ�, single abstract method interfaces
    ��Ҫ����lambda���ʽ�ͷ���������

    ֻ���ñ���������������Ƿ���һ������ʽ�ӿ�
     */
    @FunctionalInterface
    interface AcFunction {
        @SuppressWarnings("unused")
        void printlnMessage(String message);
    }
    // ��ô�Ϳ���ʹ��Lambda���ʽ����ʾ�ýӿڵ�һ��ʵ��
    @SuppressWarnings("unused")
    AcFunction acFunction = message -> System.out.println(message);
    /*
    ����ʽ�ӿ���ֻ��������һ�����󷽷�
    ����ʽ�ӿ�����������Ĭ�Ϸ�����
    ����ʽ�ӿ��������徲̬����
    ����ʽ�ӿ���������(@Override)java.lang.Object���public����
     */

    // annotations that apply to other annotations
    
}
