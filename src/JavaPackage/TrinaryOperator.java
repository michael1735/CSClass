package JavaPackage;

public class TrinaryOperator {
    public static void main(String[] args) {
        int height1 = 150;
        int height2 = 210;
        int height3 = 165;

        // Ctrl + alt + L IDEA�Զ���ʽ������, ��QQ��ͻ
        int temp = height1 > height2 ? height1 : height2;
        int max = temp > height3 ? temp : height3;

        System.out.println(max);
    }
}
