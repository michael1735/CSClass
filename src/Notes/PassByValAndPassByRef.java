package Notes;

public class PassByValAndPassByRef {
    public static void main(String[] args) {
        // java对传参的定义是: all data is passed by value
        /*
        but:
        对于元数据类型， value在每一次传入的时候都是原值;
        对于引用类型和数组,
        The value associated with an object is actually a pointer, called a reference, to the object in memory
        如: Foo foo = new Foo();
        foo这个变量存储的值是指向被创建的foo对象的一个指针, 传参的时候就是直接复制这个指针
        (我现在理解成的就是indirect addressing)
        因此在java中用方法改变对象的field的时候会改变这个对象的属性.
        也就是说方法体内的参数又有另一个单独的指针指向Foo这个obj, 然后离开作用域之后函数里的那个指针就被drop掉了
        但是函数外foo的指向仍然是Foo object的地址, 所以反映出来是Foo对象的field被函数改变了

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
    // toString 方法在输出对象名时会自动调用(用@Override来指示重载)
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
