package JavaPackage;

public class CommandLineArguments {
    // java�����д���
    public static void main(String[] args) {
        // ֱ����idea�����л����if
        if (args.length == 0) {
            System.err.println("There was no command line arguments passed!");
            System.exit(-1);
        }

        System.out.println(args[0]);
        System.out.println(args[1]);
        // open in terminal!
    }
}
