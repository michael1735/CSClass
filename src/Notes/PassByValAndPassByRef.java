package Notes;

public class PassByValAndPassByRef {
    public static void main(String[] args) {
        // java�Դ��εĶ�����: all data is passed by value
        /*
        but:
        ����Ԫ�������ͣ� value��ÿһ�δ����ʱ����ԭֵ;
        �����������ͺ�����,
        The value associated with an object is actually a pointer, called a reference, to the object in memory
        ��: Foo foo = new Foo();
        foo��������洢��ֵ��ָ�򱻴�����foo�����һ��ָ��, ���ε�ʱ�����ֱ�Ӹ������ָ��
        (���������ɵľ���indirect addressing)
        �����java���÷����ı�����field��ʱ���ı�������������.
        Ҳ����˵�������ڵĲ���������һ��������ָ��ָ��Foo���obj, Ȼ���뿪������֮��������Ǹ�ָ��ͱ�drop����
        ���Ǻ�����foo��ָ����Ȼ��Foo object�ĵ�ַ, ���Է�ӳ������Foo�����field�������ı���

        Java Language Specification: An object is a class instance or an array.
         */

        // Examples on primitive types
        // Assigning values to a variable

        // value of someValue at that time is copied to anotherValue
        int someValue = 10;
        int anotherValue = someValue;
        someValue = 17;
        System.out.println("Some value: " + someValue);
        System.out.println("Another Value: " + anotherValue);

        // passing values to method(primitive)
        // changes are not preserved when the method scope is exited
        int someValue1 = 7;
        System.out.println("Before calling method (value = " + someValue1 + ")");
        process(someValue1);
        System.out.println("After calling method (value = " + someValue1 + ")");

        // object type example
        // assigning values to a variable
        PassByValAndPassByRef someRef = new PassByValAndPassByRef();
        System.out.println("Some obj before creating another obj = " + someRef);
        PassByValAndPassByRef anotherRef = someRef;
        someRef = new PassByValAndPassByRef();
        System.out.println("some obj = " + someRef);
        System.out.println("Another obj = " + anotherRef);

        // passing values to methods
        VehicleProcessor processor = new VehicleProcessor();
        Vehicle vehicle = new Vehicle("Some name");
        System.out.println("Before calling method (vehicle = " + vehicle + ")");
        processor.process(vehicle);
        System.out.println("After calling method (vehicle = " + vehicle + ")");
        processor.processWithReferenceChange(vehicle);
        System.out.println("After calling reference-change method (vehicle = " + vehicle + ")");
    }

    public static void process(int value) {
        System.out.println("Entered method (value = " + value + ")");
        value = 50;
        System.out.println("Changed value within method (value = " + value + ")");
        System.out.println("Leaving method (value = " + value + ")");
    }
}

class Vehicle {
    private String name;

    public Vehicle(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Vehicle[name = " + name + "]";
    }
    // toString ���������������ʱ���Զ�����(��@Override��ָʾ����)
}

class VehicleProcessor {
    public void process(Vehicle vehicle) {
        System.out.println("Entered method (vehicle = " + vehicle + ")");
        vehicle.setName("A changed name");
        System.out.println("Changed vehicle within method (vehicle = " + vehicle + ")");
        System.out.println("Leaving method (vehicle = " + vehicle + ")");
    }

    public void processWithReferenceChange(Vehicle vehicle) {
        System.out.println("Entered method (vehicle = " + vehicle + ")");
        vehicle = new Vehicle("A new name");
        System.out.println("New vehicle within method (vehicle = " + vehicle + ")");
        System.out.println("Leaving method (vehicle = " + vehicle + ")");
    }
}
