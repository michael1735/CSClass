package JavaPackage;

public class LogicOperatorDemo {
    public static void main(String[] args) {
        // 1.& 逻辑与
        // 两边都为真结果才是真
        System.out.println(true & true); // t
        System.out.println(false & false); // f
        System.out.println(true & false); // f
        System.out.println(false & true); // f
        System.out.println();

        // 2. | 逻辑或
        // 两边都为假, 结果才是假
        System.out.println(true | true); // t
        System.out.println(false | false); // f
        System.out.println(true | false); // t
        System.out.println(false | true ); // t
        System.out.println();

        // 3. ^ 逻辑异或
        System.out.println(true ^ true);
        System.out.println(false ^ false);
        System.out.println(true ^ false);
        System.out.println(false ^ true);
        System.out.println();

        // 4. !逻辑非
        System.out.println(!true);
        System.out.println(!false);
        System.out.println();

        // 5. && 短路与
        // 两个都为真则真
        // 一边为假就全假
        // 比逻辑与省时间和空间
        System.out.println(true && true);
        System.out.println(true && false);
        System.out.println(false && false);
        System.out.println(false && true);
        System.out.println();

        // 6. || 短路或
        // 两个都为假则假
        // 一边为真则全真
        // 比逻辑或省空间和时间
        System.out.println(true || true);
        System.out.println(false || false);
        System.out.println(false || true);
        System.out.println(true || false);
        System.out.println();

        // 7. 短路运算符具有短路效果
        // 简单理解: 当左边的表达式能确定最终结果, 右边的就不会参与运行
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
