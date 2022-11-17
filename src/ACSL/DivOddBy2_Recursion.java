package ACSL;

public class DivOddBy2_Recursion {
    public static void main(String[] args) {
        System.out.println(div(50));
    }

    static int div(int num) {
        if (num == 1){
            return num;
        } else {
            System.out.println(num / 2);
            return div(num / 2);
        }
    }
}
