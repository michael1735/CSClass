package JavaPackage;

public class LambdaExpressions {
    /*
    lambda���ʽֻ�����ñ����final�����ֲ�����(lambda�ڲ����޸����ľֲ�����)
    Ҳ����effectively-final
     */
    public static void main(String[] args) {
        // �հ�, ����Ѻ�����Ϊ�������ݽ�������
        LambdaExpressions lambda = new LambdaExpressions();

        // ����������
        MathOperation addition = (int a, int b) -> a + b;

        // ������������
        MathOperation subtraction = (a, b) -> a - b;

        // �������еķ������
        MathOperation multiplication = (int a, int b) -> { return a * b; };

        // û�д����ż��������
        MathOperation division = (int a, int b) -> a / b;

        System.out.println("10 + 5 = " + lambda.operate(10, 5, addition));
        System.out.println("10 - 5 = " + lambda.operate(10, 5, subtraction));
        System.out.println("10 * 5 = " + lambda.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + lambda.operate(10, 5, division));

        // ��������
        GreetingService greetingService1 = message ->
            System.out.println("hello" + message);

        // ������
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

    // TODO: java��lambda��û����, ѧ��̳�֮�������֮����Ū
    // lambda expressions don't have any shadowing issues
    // they can capture variables, they have the same access to local variables of the enclosing scope
}
