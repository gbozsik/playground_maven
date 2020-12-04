package thread;

import java.util.List;
import java.util.concurrent.*;

public class CompletableFutureRunner {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String name = null;
        CompletableFuture<String> completableFuture1 = CompletableFuture.supplyAsync(() -> {
            if (name == null) {
                throw new RuntimeException("computation error");
            }
            return "Hello" + name;
        }).handle((selectedTabName, throwable) -> selectedTabName != null ? selectedTabName : "hello stranger");
        CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(() -> "beautifull");
        CompletableFuture<String> completableFuture3 = CompletableFuture.supplyAsync(() -> "world");
        CompletableFuture<String> completableFuture4 = completableFuture1.thenApply((s) -> s + " World");

        CompletableFuture<String> exeptionallyCompletableFuture = new CompletableFuture<>();
//        exeptionallyCompletableFuture.completeExceptionally(
//                new RuntimeException("handle exeptionally"));
//        System.out.println(exeptionallyCompletableFuture.get());

        CompletableFuture<Void> combinedCompletableFuture = CompletableFuture.allOf(completableFuture1, completableFuture2, completableFuture3);
        System.out.println(combinedCompletableFuture.get());
        System.out.println("start");
        System.out.println(completableFuture2.get());

        System.out.println("1 is complete " + completableFuture1.isDone());
        System.out.println("2 is complete " + completableFuture2.isDone());
        System.out.println("3 is complete " + completableFuture3.isDone());

        List<CompletableFuture<String>> completableFutureList = List.of(completableFuture1, completableFuture2, completableFuture3);
        String result = "";
        for (int i = 0; i < completableFutureList.size(); i++) {
                        result += completableFutureList.get(i).get() + " ";
        }
        System.out.println("result: " + result);
    }

    private static Future<String> calculateAsync(int waitTime, String message) {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(() -> {
            Thread.sleep(waitTime);
            completableFuture.complete(message);
            return null;
        });
        executorService.shutdown();
        return completableFuture;
    }
}
