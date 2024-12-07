package io.hubbell.fung.Demos;

public class MultithreadedCounter {
    private int counter = 0;

    // Synchronized method to increment counter
    public synchronized void increment(String threadName) {
        counter++;
        System.out.println(threadName + " incremented counter to " + counter);
    }

    public void incrementSequential() {
        counter++;
        System.out.println("Sequential increment: Counter incremented to " + counter);
    }

    public int getCounter() {
        return counter;
    }

    public static void main(String[] args) throws InterruptedException {

        // Sequential Execution
        System.out.println("Starting Sequential Execution");
        MultithreadedCounter sequentialCounter = new MultithreadedCounter();
        long seqStartTime = System.currentTimeMillis();
        for (int i = 0; i < 15; i++) {
            sequentialCounter.incrementSequential();
        }
        long seqEndTime = System.currentTimeMillis();
        System.out.println("Final Counter Value after Sequential Execution: " + sequentialCounter.getCounter());
        System.out.println("Time taken (Sequential): " + (seqEndTime - seqStartTime) + " ms\n");



        // Multithreaded Execution
        System.out.println("Starting Multithreaded Execution");
        MultithreadedCounter threadedCounter = new MultithreadedCounter();
        long mtStartTime = System.currentTimeMillis();

        // Create threads
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                threadedCounter.increment("Thread-1");
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                threadedCounter.increment("Thread-2");
            }
        });

        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                threadedCounter.increment("Thread-3");
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

        long mtEndTime = System.currentTimeMillis();
        System.out.println("Final Counter Value after Multithreaded Execution: " + threadedCounter.getCounter());
        System.out.println("Time taken (Multithreaded): " + (mtEndTime - mtStartTime) + " ms\n");

        // Efficiency Comparison
        System.out.println("Efficiency Comparisons:");
        System.out.println("Sequential vs. Multithreaded: " + (seqEndTime - seqStartTime) + " ms vs. " + (mtEndTime - mtStartTime) + " ms");
    }
}
