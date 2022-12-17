package 算法;

public class Note2 {
    public static void main(String[] args) {
        int a;
        a = 100;
        System.out.println(a);

        a = a + a;
        System.out.println(a);

        // int a = 10;
        // 无法编译，因为同时写两个int a = 100; 相当于让电脑同时声明两个相同命名的存储空间
    }

    public static void doSome(){
        int a = 10;
        System.out.println(a); // 不会冲突
    }
}
