package thread.executorservice;

public class Task implements Runnable {

    private final int number;

    public Task(int number) {
        this.number = number;
    }


    @Override
    public void run() {
        System.out.println("\nTask: " + number + " started");
        for (int i = number*100; i < number*100 + 99; i++) {
            System.out.print(i + " ");
        }
        System.out.println("\nTask: " + number + " done");

    }
}
