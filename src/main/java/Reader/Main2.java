package Reader;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main2 {
    public static void main(String[] args) {
        Executor executor = new Executor();
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        while (true) {
            executorService.submit(new Thread(executor::fileProcessing));

        }
    }
}
