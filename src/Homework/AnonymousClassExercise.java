package Homework;

public class AnonymousClassExercise {
    interface Bell {
        void ring();
    }

    public static void main(String[] args) {
        class CellPhone {
            public void alarmClock(Bell bell) {
                bell.ring();
            }
        }
        CellPhone cellPhone = new CellPhone();

        cellPhone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("wake up, lazy boy");
            }
        });

        cellPhone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("go to class now");
            }
        });
    }
}
