package JavaPackage.AnnotationsDemo;

/*
Note: To make the information in @ClassPreamble appear in Javadoc-generated documentation,
you must annotate the @ClassPreamble definition with the @Documented annotation:
 */

// import this to use @Documented
import java.lang.annotation.*;
public class AnnotationDefinition {
    // Annotations, a form of metadata, provide data about a program that is not part of the program itself.
    // Annotations have no direct effect on the operation of the code they annotate.
    /*
    simplest form : @Entity

    include elements :
    @Author(
        name = "Benjamin Franklin",
        date = "3/27/2003"
    )
    class MyClass{...}

    use multiple annotations on the same declaration
    @Author(name = "Jane Doe")
    @Author(name = "John Smith")
    class myClass {...}

    repeating annotation(multiple annotations of the same type):
    @Author(name = "Jane Doe")
    @Author(name = "John Smith")
    class MyClass {...}
    (Java 8 and later)

    where they can be used:
    declarations && use of types(type annotation)
     */

    // to add the metadata, you need to first define the annotation type
    // add @Documented to make the information in ClassPreamble appear in javadoc-generated documentation
    @Documented
    @interface ClassPreamble {
        String author();
        String date();
        int currentRevision() default 1;
        String lastModified() default "N/A";
        String lastModifiedBy() default "N/A";
        // note use of array
        String[] reviewers();
    }
    // Annotation types are a form of interface!!!
    /*
    The body of the previous annotation definition contains annotation type element declarations,
    which look a lot like methods. Note that they can define optional default values.
     */
}
// now use your newly defined annotation type!!
@AnnotationDefinition.ClassPreamble(
        author = "Jane Doe",
        date = "3/17/2002",
        currentRevision = 6,
        lastModified = "4/12/2004",
        lastModifiedBy = "Jane Doe",
        // note array notation
        reviewers = {"alice", "bob", "cindy"}
)
class Person {
    private int age;
    private String race;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(int age, String race, String name) {
        this.age = age;
        this.race = race;
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", race='" + race + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
