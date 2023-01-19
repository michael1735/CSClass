package JavaPackage;

public class CommandLineArguments {
    // java命令行传参
    public static void main(String[] args) {
        // 直接在idea里运行会进入if
        if (args.length == 0) {
            System.err.println("There was no command line arguments passed!");
            System.exit(-1);
        }

        System.out.println(args[0]);
        System.out.println(args[1]);
        // open in terminal!
    }
}
