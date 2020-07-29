public class Main {

    public static void main(String[] args) {

        Thread workerThread1 = new Thread(new RunnableWorker(), "worker-1");

        Thread workerThread2 = new Thread(new RunnableWorker(), "worker-2");

        Thread workerThread3 = new Thread(new RunnableWorker(), "worker-3");

        workerThread1.start();
        workerThread2.start();
        workerThread3.start();
    }
}

// Don't change the code below       
class RunnableWorker implements Runnable {

    @Override
    public void run() {
        final String name = Thread.currentThread().getName();

        if (name.startsWith("worker-")) {
            System.out.println("too hard calculations...");
        }
    }
}