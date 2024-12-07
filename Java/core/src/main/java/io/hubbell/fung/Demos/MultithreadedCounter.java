package io.hubbell.fung.Demos;


public class MultithreadedCounter {
    private int counter = 0;

    // Synchronized method to increment counter
    public synchronized void increment(String threadName) {
        counter++;
        System.out.println(threadName + " incremented counter to " + counter);
    }

    public int getCounter() {
        return counter;
    }

    public static void main(String[] args) throws InterruptedException {
        MultithreadedCounter counter = new MultithreadedCounter();

        // Create threads
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                counter.increment("Thread-1");
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                counter.increment("Thread-2");
            }
        });

        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                counter.increment("Thread-3");
            }
        });

        // Start threads
        thread1.start();
        thread2.start();
        thread3.start();

        // Wait for threads to finish
        thread1.join();
        thread2.join();
        thread3.join();

        // Verify the final counter value
        System.out.println("Final Counter Value: " + counter.getCounter());
    }
}
