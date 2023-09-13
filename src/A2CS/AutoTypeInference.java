package A2CS;

public class AutoTypeInference {
    // 正如同c++有auto, rust有let, java从10开始就有了自动类型推断功能
    public static void main(String[] args) {
        var language = "Java"; // String
        var version = 10; // int
        System.out.println(language + version);
    }
}
