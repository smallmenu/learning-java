package com.niuchaoqun.example.thread.wt;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;

public class ClientThreadWithExecutor extends Thread {
    private final ExecutorService executorService;

    private static final Random random = new Random();

    public ClientThreadWithExecutor(String name, ExecutorService executorService) {
        super(name);
        this.executorService = executorService;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; true; i++) {
                RequestWithRunnable request = new RequestWithRunnable(getName(), i);
                executorService.execute(request);
                Thread.sleep(random.nextInt(100));
            }
        } catch (InterruptedException e) {
        } catch (RejectedExecutionException e) {
            System.out.println(getName() + " : " + e);
        }
    }
}
