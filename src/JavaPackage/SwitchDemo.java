package JavaPackage;

public class SwitchDemo {
    public static void main(String[] args) {
        /*
        Default ��λ�ú�ʡ��
        λ��: default λ����ѡ, ����ϰ����д��������
        ʡ��: ����ʡ��, ��������
         */

        /*
        case ��͸: ָ����break�����
         */
        /*
        case������: jdk12 and after
         */
        int number = 1;
        switch (number) {
            case 1 -> System.out.println("1");
            case 2 -> System.out.println("2");
            case 3 -> System.out.println("3");
            default -> System.out.println("û������ѡ��");
        }
    }
}
