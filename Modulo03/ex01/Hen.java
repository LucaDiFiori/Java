public class Hen implements Runnable {
    private final ThreadPrinter threadPrinter;
    private final int count;

    public Hen(ThreadPrinter threadPrinter, int count) {
        this.threadPrinter = threadPrinter;
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            threadPrinter.henPrint();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}