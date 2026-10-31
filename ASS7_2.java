
class Buffer {

    int item;
    boolean available = false;

    // Producer adds item
    synchronized void produce(int value) {

        try {

            while (available) {
                wait();
            }

            item = value;
            available = true;

            System.out.println("Produced: " + item);

            notify();

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // Consumer removes item
    synchronized void consume() {

        try {

            while (!available) {
                wait();
            }

            System.out.println("Consumed: " + item);

            available = false;

            notify();

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

// Producer thread
class Producer extends Thread {

    Buffer buffer;

    Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {

        for (int i = 1; i <= 5; i++) {
            buffer.produce(i);
        }
    }
}

// Consumer thread
class Consumer extends Thread {

    Buffer buffer;

    Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {

        for (int i = 1; i <= 5; i++) {
            buffer.consume();
        }
    }
}

public class Main {

    public static void main(String[] args) {

        // Shared buffer
        Buffer buffer = new Buffer();

        // Creating threads
        Producer p = new Producer(buffer);
        Consumer c = new Consumer(buffer);

        // Starting threads
        p.start();
        c.start();

        try {

            p.join();
            c.join();

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();
        }

        System.out.println("Producer-Consumer process completed.");
    }
}
