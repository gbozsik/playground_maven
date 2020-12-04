package thread.executorservice;

public class Task1 extends Thread {

    public void run() {
        System.out.println("Task1 started");

        for (int i = 101; i < 199; i++) {
            System.out.print(i + " ");
        }
        System.out.println("\nTask1 is done");
    }
}
