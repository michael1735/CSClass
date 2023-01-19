package JavaPackage.EnumTest;

/*
        The enum declaration defines a class (called an enum type). The enum class body can include methods and other
        fields. The compiler automatically adds some special methods when it creates an enum.

        For example, they have a static values method that returns an array containing all the values of the enum
        in the order they are declared. This method is commonly used in combination with the for-each construct to
        iterate over the values of an enum type.
         */

        /*
        Note: All enums implicitly extend java.lang.Enum. Because a class can only extend one parent (see Declaring
        Classes), the Java language does not support multiple inheritance of state (see Multiple Inheritance of State,
        Implementation, and Type), and therefore an enum cannot extend anything else.
         */

/*
Note: The constructor for an enum type must be package-private or private access. It automatically creates
the constants that are defined at the beginning of the enum body. You cannot invoke an enum constructor yourself.
 */
public enum Planet {
    MERCURY (3.303e+23, 2.4397e6),
    VENUS (4.869E+24, 6.0518E6),
    EARTH (5.976e+24, 6.37814e6),
    MARS (6.421e+23, 3.3972e6),
    JUPITER (1.9e+27,   7.1492e7),
    SATURN  (5.688e+26, 6.0268e7),
    URANUS  (8.686e+25, 2.5559e7),
    NEPTUNE (1.024e+26, 2.4746e7);

    private final double mass; // in kilograms
    private final double radius; // in metres

    /*
    In addition to its properties and constructor, Planet has methods that allow you to retrieve the surface gravity
    and weight of an object on each planet. Here is a sample program that takes your weight on earth (in any unit) and
    calculates and prints your weight on all of the planets (in the same unit):
     */
    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
    }
    private double mass() {return mass;}
    private double radius() {return radius;}

    // universal gravitational constant (m3 kg-1 s-2)
    public static final double G = 6.67300E-11;

    double surfaceGravity() {
        return G * mass / (radius * radius);
    }

    double surfaceWeight(double otherMass) {
        return otherMass * surfaceGravity();
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java Planet <earth_weight>");
            System.exit(-1);
        }
        double earthWeight = Double.parseDouble(args[0]);
        double mass = earthWeight / EARTH.surfaceGravity();
        for (Planet p : Planet.values()) {
            System.out.printf("Your weight on %s is %f%n", p, p.surfaceWeight(mass));
        }
    }
}
