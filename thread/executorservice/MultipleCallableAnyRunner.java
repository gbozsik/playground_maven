package thread.executorservice;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultipleCallableAnyRunner {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long startTime = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<CallableRunner.CallableTask> tasks = List.of(new CallableRunner.CallableTask("this is the callable task 1"),
                new CallableRunner.CallableTask("this is the callable task 2"),
                new CallableRunner.CallableTask("this is the callable task 3"));

        String future = executorService.invokeAny(tasks);


            System.out.println(future);

        System.out.println("main is done");
        executorService.shutdown();
        long endTime = System.currentTimeMillis();
        System.out.println("Time elapsed: " + (endTime - startTime));
    }
}
