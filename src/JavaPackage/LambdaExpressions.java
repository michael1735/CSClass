package JavaPackage;

public class LambdaExpressions {
    /*
    lambda表达式只能引用标记了final的外层局部变量(lambda内不可修改外层的局部变量)
    也可以effectively-final
     */
    public static void main(String[] args) {
        // 闭包, 允许把函数作为参数传递进方法中
        LambdaExpressions lambda = new LambdaExpressions();

        // 有类型声明
        MathOperation addition = (int a, int b) -> a + b;

        // 不用类型声明
        MathOperation subtraction = (a, b) -> a - b;

        // 大括号中的返回语句
        MathOperation multiplication = (int a, int b) -> { return a * b; };

        // 没有大括号及返回语句
        MathOperation division = (int a, int b) -> a / b;

        System.out.println("10 + 5 = " + lambda.operate(10, 5, addition));
        System.out.println("10 - 5 = " + lambda.operate(10, 5, subtraction));
        System.out.println("10 * 5 = " + lambda.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + lambda.operate(10, 5, division));

        // 不用括号
        GreetingService greetingService1 = message ->
            System.out.println("hello" + message);

        // 用括号
        GreetingService greetingService2 = (message) ->
                System.out.println("hello" + message);

        greetingService1.sayMessage("Runoob");
        greetingService2.sayMessage("Google");
    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }

    // TODO: java的lambda还没看懂, 学完继承之类的特性之后再弄
    // lambda expressions don't have any shadowing issues
    // they can capture variables, they have the same access to local variables of the enclosing scope
}
