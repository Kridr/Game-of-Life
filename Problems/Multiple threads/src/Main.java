public class Main {

    public static void main(String[] args) {

        Thread workerThread1 = new WorkerThread();
        workerThread1.setName("worker-A");

        Thread workerThread2 = new WorkerThread();
        workerThread2.setName("worker-B");

        workerThread1.start();
        workerThread2.start();
    }
}

// Don't change the code below
class WorkerThread extends Thread {

    private static final int NUMBER_OF_LINES = 3;

    @Override
    public void run() {
        final String name = Thread.currentThread().getName();

        if (!name.startsWith("worker-")) {
            return;
        }

        for (int i = 0; i < NUMBER_OF_LINES; i++) {
            System.out.println("do something...");
        }
    }
}