package JavaPackage.EnumTest;

public class EnumDemo {
    // An enum type is a special data type that enables for a variable to be a set of predefined constants.
    // The variable must be equal to one of the values that have been predefined for it.
    // Because they are constants, the names of an enum type's fields are in uppercase letters.
    public enum Day {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
    }
    /*
     you should use enum types any time you need to represent a fixed set of constants.

     That includes natural enum types such as the planets in our solar system
     and data sets where you know all possible values at compile time¡ªfor example,
     the choices on a menu, command line flags, and so on.
     */
    Day day;
    public EnumDemo(Day day) {
        this.day = day;
    }

    public void tellItLikeItIs() {
        switch (day) {
            case MONDAY -> System.out.println("Mondays are bad");
            case FRIDAY -> System.out.println("Fridays are better");
            case SATURDAY, SUNDAY -> System.out.println("Weekends are best");
            default -> System.out.println("Midweek days are so-so");
        }
    }

    public static void main(String[] args) {
        EnumDemo firstDay = new EnumDemo(Day.MONDAY);
        firstDay.tellItLikeItIs();
        EnumDemo thirdDay = new EnumDemo(Day.WEDNESDAY);
        thirdDay.tellItLikeItIs();
        EnumDemo fifthDay = new EnumDemo(Day.FRIDAY);
        fifthDay.tellItLikeItIs();
        EnumDemo sixthDay = new EnumDemo(Day.SATURDAY);
        sixthDay.tellItLikeItIs();
    }
}
