package section10;

import java.util.concurrent.TimeUnit;

public class StopThread {
    private static boolean stopRequested;

    private static synchronized void requestStop() {
        stopRequested=true;
    }

    private static synchronized boolean stopRequest() {
        return stopRequested;
    }
    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread=new Thread(new Runnable() {
            @Override
            public void run() {
                int i=0;
                while (!stopRequest()) {
                    i++;
                }
            }
        });
        backgroundThread.start();
        TimeUnit.SECONDS.sleep(1);
        requestStop();
    }
}
