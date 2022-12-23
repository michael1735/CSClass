package Algorithms;

public class DataTypeDemo {
    /**
     * 1. primitive data types Ԫ��������
     * atomic data types(���������������)
     * - INTEGER
     * - REAL
     * - BOOLEAN
     * - CHAR
     *
     * 2. Further data types
     * - string
     * - date
     *
     * 3. UDT(composite data type, ������)
     * user-defined-data type
     * ʵ�ʵ���������: record data type
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
    public record Person(
            String name,
            String ability,
            String email,
            int age
    ){

    }
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

        Person p1 = new Person("Jaslo", "Programming", "JasloC@whbc2000.com", 23);
        System.out.println(p1);
    }

    /*
    Abstract Data Type:
    1. array
    2. stack
    3. queue
    4. linked-list

    stack ջ
    ����, ��һ��base pointer��һ��top pointer
    BasePointer��Զָ���һ��λ�ã�Top��û�����ݵ�ʱ����Զָ��-1�������ݺ�������Ƶ����
    ����ȳ�
    FILO/LIFO

    queue ����
    FIFO-first in, first
    out (& last in last out)
    FrontPointer&EndPointer
    frontPointer -> ָ��-1
    endPointer -> �������Ϊ��, ָ��-1
    circular:?

    DECLARE stack:ARRAY OF INTEGER

    linked-list
    ����
    linear data structure
    �����Խṹ, ���ǲ������Դ洢(����ַ˳��)��
    �Կ�ָ�����
     */
    // �����ڵ�,,, ����֮����ѧ
}
