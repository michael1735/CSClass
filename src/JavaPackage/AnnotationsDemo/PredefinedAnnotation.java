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
    // Javadoc里的annotation和对应的代码处annotation是相互联系的, javadoc里用小写首字母, Java里用大写首字母
    // 就是说@Depreciated应该在对应的javadoc文档里加入@depreciated解释为啥失效
    /**
     * @deprecated
     * explanation of why it has depreciated
     */
    @Deprecated
    static void depreciatedMethod() {
        System.out.println("this method has depreciated");
    }

    // @Override
    // 这个元素重写了其超集里定义的一个方法
    @Override
    public String toString() {
        return "this overrides the method in java.lang.Object";
    }
    // @Override可以避免错误, 如果一个被标记为@Override的方法并没有正确的重写它父类的方法编译器会报错

    // @SuppressWarnings
    // 用于告诉编译器不显示特定警告
    // 如@SuppressWarnings("depreciation")
    // 多个元素可以用数组的语法
    // @SuppressWarnings({"depreciation", "unchecked"})
    /*
    常用: all(所有)
    dep-ann(与注释里的@depreciated相关的警告)
    fallthrough(switch里没break)
    incomplete-switch(switch(enum case)中遗漏项目)
    javadoc(抑制与javadoc相关的警告 nls, 抑制与非nls字串文字相关的警告 null, 抑制与空值分析相关的警告)
    unused(未使用变量, 函数, 类...)
    unchecked(未检查类型, 常出现在泛型的使用中)
     */
    @SuppressWarnings({"unchecked", "unused"})
    public void uncheckedTest(Map<String, ?> map) {
        Map<String, String> resultMap = (Map<String, String>) map;
    }
    /*
    其实不不需要记住这么多, IDEA可以自动生成
    点灯泡符号, Try to generify xxx -> suppress for method
    反正就是suppress for xxx即可自动生成对应的注解
     */

    /*
    模糊类型声明会报unchecked警告(如泛型), 因此
    如果程序员断定声明的构造函数和方法的主体不会对其varargs参数执行潜在的不安全的操作,
    可使用@SafeVarargs进行标记, 这样的话, Java编译器就不会报unchecked警告。

    @SafeVarargs注解, 只能用于标记构造函数和方法, 由于保留策略声明为RUNTIME, 所以此注解可以在运行时生效.
    只能用于static/final方法, 非static/final用@SuppressWarnings("unchecked")
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
        display("10", 20, 30); // 用@SafeVarargs来压下这个问题
    }

    /*
    @FunctionalInterface
    函数式接口, 只包含一个抽象方法的接口
    也称为SAM接口, single abstract method interfaces
    主要用在lambda表达式和方法引用上

    只会让编译器主动检查这是否是一个函数式接口
     */
    @FunctionalInterface
    interface AcFunction {
        @SuppressWarnings("unused")
        void printlnMessage(String message);
    }
    // 那么就可以使用Lambda表达式来表示该接口的一个实现
    @SuppressWarnings("unused")
    AcFunction acFunction = message -> System.out.println(message);
    /*
    函数式接口里只允许声明一个抽象方法
    函数式接口里是允许定义默认方法的
    函数式接口里允许定义静态方法
    函数式接口里允许定义(@Override)java.lang.Object里的public方法
     */

    // annotations that apply to other annotations
    
}
