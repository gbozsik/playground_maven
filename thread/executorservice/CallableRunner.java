package thread.executorservice;

import java.util.concurrent.*;

public class CallableRunner {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<String> stringFuture = executorService.submit(new CallableTask("this is the callable task"));

        System.out.println("future executed");
        String message = stringFuture.get();
        System.out.println(message);
        System.out.println("main completed");
        executorService.shutdown();
    }

    protected static class CallableTask implements Callable<String> {

        private final String name;

        public CallableTask(String name) {
            this.name = name;
        }

        @Override
        public String call() throws Exception {
            Thread.sleep(1000);
            return "Hello " + name;
        }
    }
}
