package thread;

public class DeadLock {

    public static void main(String[] args) throws InterruptedException {
        String s1 = "s1";
        String s2 = "s2";
        Counter c = new Counter();
        Thread thread1 = new Thread(() -> {
            synchronized (s1) {
                System.out.println("start s1");
                for (int i = 0; i < 100000; i++) {
                    System.out.println("increment s1 " + i);
                    c.increment();
                }
                synchronized (s2) {
                    System.out.println("s2 in s1");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (s2) {
                System.out.println("start s2");
                for (int i = 0; i < 100000; i++) {
                    System.out.println("increment s2 " + i);
                    c.increment();
                }
                synchronized (s1) {
                    System.out.println("s1 in s2");
                }
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(c.count);
    }

}

class Counter {
    int count = 0;

    void increment() {
        count++;

    }
}
