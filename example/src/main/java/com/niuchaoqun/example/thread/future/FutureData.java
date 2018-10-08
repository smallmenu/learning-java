package com.niuchaoqun.example.thread.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureData extends FutureTask<RealData> implements Data {

    public FutureData(Callable<RealData> callable) {
        super(callable);
    }

    @Override
    public synchronized String getContent() {
        String string = null;

        try {
            string = get().getContent();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return string;
    }
}
