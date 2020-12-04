package thread.executorservice;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultipleCallableRunner {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long startTime = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<CallableRunner.CallableTask> tasks = List.of(new CallableRunner.CallableTask("this is the callable task 1"),
                new CallableRunner.CallableTask("this is the callable task 2"),
                new CallableRunner.CallableTask("this is the callable task 3"));

        List<Future<String>> futureList = executorService.invokeAll(tasks);

        for (Future<String> stringFuture : futureList) {
            System.out.println(stringFuture.get());
        }
        System.out.println("main is done");
        executorService.shutdown();
        long endTime = System.currentTimeMillis();
        System.out.println("Time elapsed: " + (endTime - startTime));
    }
}
