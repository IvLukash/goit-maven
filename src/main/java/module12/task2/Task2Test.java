package module12.task2;

public class Task2Test {
    public static void main(String[] args) {
        Thread.currentThread().setName("D");
        ThreadsTask2 myThread = new ThreadsTask2(34);
        Thread one = new Thread(myThread::fizz, "A");
        Thread two = new Thread(myThread::buzz, "B");
        Thread three = new Thread(myThread::fizzbuzz, "C");

        one.start();
        two.start();
        three.start();

        try {
            one.join();
            two.join();
            three.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        myThread.number();
    }
}
