package xamples.threads;

import org.testng.annotations.Test;

class MyTask implements Runnable {

    volatile boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            System.out.println(Thread.currentThread().getName() + " працює");
            System.out.println(Thread.currentThread().getState());
        }
    }

    public void stopThread() {
        flag = false;
    }

}

public class Threads {
    @Test
    public void test() throws InterruptedException {
        MyTask task1 = new MyTask();
        MyTask task2 = new MyTask();
        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        thread1.start();
        thread2.start();

        Thread.sleep(100); // даємо попрацювати
        task1.stopThread();       // попросили зупинитись
        task2.stopThread();       // попросили зупинитись

        thread1.join();  // блокуєм мейн щоб дочекатись на точне завершення потоку
        thread2.join();  // блокуєм мейн щоб дочекатись на точне завершення потоку
        System.out.println("THREAD 1: " + thread1.getState());
        System.out.println("THREAD 2: " +thread2.getState());

    }
}
