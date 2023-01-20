package JavaPackage;

public class JavaAssert {
    // assert 意为断言, 可以判断布尔表达式的结果是否和预期一样
    /*
    assert有两种用法：

   （1）asset expression1;

   （2）asset expression1 : expression2;

    第一种用法在刚才的例子里面已经看到了，第二种用法，其实后面的表达式是允许我们自定义一个异常错误信息抛出。
     */

    /*
    注意，在运行的时候，正常情况下assert是不会生效的，因为运行时assert是关闭的，想要使用，必须在VM启动参数中开启：
    -enableassertions /-ea
     */
    // assert功能只能测试使用, 因为会损耗性能, 且因为要在命令行打开参数, 容易忘记
    public static void checkName(String name) {
        assert name != null : "name is empty!";
    }

    public static void main(String[] args) {
        checkName(null); // java -ea JavaAssert.java
        /*
        IDEA可以在RUN -> Modify Configurations -> Modify Options -> Add VM Options -> 然后改此应用程序的运行参数
         */

        // 生产上不能用assert, 但是可以用工具类来实现其功能
        /*
        1. spring环境, Assert工具类
        Assert.notNull(obj, "obj was null")

        2.Objects.requireNonNull()

        3.(from junit)
        Assert.assertNotNull()
         */
    }
}
