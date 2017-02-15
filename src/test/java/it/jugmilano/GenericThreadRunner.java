package it.jugmilano;

import java.util.concurrent.Callable;

public class GenericThreadRunner {

    private Callable<Boolean> executor;
    private boolean result;
    private int timeout = 1000;

    public GenericThreadRunner(Callable<Boolean> executor, int timeout) {
        this.executor = executor;
        this.timeout = timeout;
    }

    private void setResult(boolean result) {

        this.result = result;
    }

    public String runExecutor() {

        Thread runner = new Thread(() -> {
            try {
                setResult(executor.call());
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        });

        runner.setDaemon(true);
        runner.start();

        try {
            Thread.currentThread().sleep(timeout);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (runner.isAlive()) {
            return "Your algorithm is taking too long.";
        }

        // this should not happen: it means that all the correctness tests are green,
        // but the efficiency test is ok for the timing but it's wrong for correctness
        // (it means that the correctness tests are not exhaustive)
        if (!result) {
            return "Your algorithm is not correct";
        }

        return null;
    }
}
