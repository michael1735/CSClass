package JavaPackage;

public class DetermineUppercase {
    public static void main(String[] args) {
        String s = "myString";
        // my own method
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                System.out.printf("The letter %s is uppercase%n", c);
            }
        }

        // method1
        int index = 2; // the index of the letter "S"
        if (s.charAt(index) >= 'A' && s.charAt(index) <= 'Z') {
            System.out.printf("The letter %s is uppercase%n", s.charAt(index));
        }
    }
}
