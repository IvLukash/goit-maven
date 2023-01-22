package module12.task1;

public class Task1Test {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        long time;
        System.out.println("Program is started");

        Thread one = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Минуло 5 секунд");
            }
            System.out.println(Thread.currentThread().getName() + " is ended");
        }, "thread one");

        one.start();

        for (int i = 0; i < 25; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            time = System.currentTimeMillis() - start;
            System.out.println(time);
        }

        System.out.println(Thread.currentThread().getName() + " is ended");
    }
}
