package Notes;

public class DataTypeDemo {
    /**
     * 1. primitive data types 元数据类型
     * atomic data types(最基本的数据类型)
     * - INTEGER
     * - REAL
     * - BOOLEAN
     * - CHAR
     *
     * 2. Further data types
     * - string
     * - date
     *
     * 3. UDT
     * user-defined-data type
     * 实际的数据类型: record data type(composite data type, 复合型)
     *
     * pseudocode:
     * TYPE <Identifier></Identifier>
     *  DECLARE <Field Identifier>
     *  .
     *  .
     *  .
     * ENDTYPE
     *
     * Code snippet:
     * TYPE PersonType
     *  Name:STRING
     *  DateOfBirth:DATE
     *  Height:REAL
     *  Weight:REAL
     * ENDTYPE
     *
     * DECLARE Person1:PersonType
     * Person1.Name <-- "a"
     * Person1.DateOfBirth <-- 01/02/2022
     * .
     * .
     *
     * OUTPUT Person1.Height
     */

    public static void main(String[] args) {
        record Employee(
                int id,
                String name,
                String email,
                int age
        ) {
        }

        Employee e1 = new Employee(10, "Jaslo", "Jaslo@whbc2000.com", 24);

        System.out.println(e1);
    }

    /*
    Abstract Data Type:
    1. array
    2. stack
    3. queue
    4. linked-list

    stack 栈
    特性, 有一个base pointer和一个top pointer
    BasePointer永远指向第一个位置，Top在没有数据的时候永远指向-1，有数据后会向上移到最高
    后进先出
    FILO/LIFO

    queue 队列
    FIFO-first in, first out (& last in last out)
     */
}
