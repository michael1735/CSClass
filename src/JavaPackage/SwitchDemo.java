package JavaPackage;

public class SwitchDemo {
    public static void main(String[] args) {
        /*
        Default 的位置和省略
        位置: default 位置任选, 但是习惯于写在最下面
        省略: 可以省略, 但不建议
         */

        /*
        case 穿透: 指不加break的情况
         */
        /*
        case新特性: jdk12 and after
         */
        int number = 1;
        switch (number) {
            case 1 -> System.out.println("1");
            case 2 -> System.out.println("2");
            case 3 -> System.out.println("3");
            default -> System.out.println("没有这种选项");
        }
    }
}
