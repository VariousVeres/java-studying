package xamples.threads;


import org.testng.annotations.Test;

class Runn implements Runnable {

    @Override
    public void run() {
        int counter = 0;
        while (counter < 20) {
            System.out.println("######### Thread: " + Thread.currentThread().getName() + " #########");
            counter++;
        }
    }
}

public class Runnables {

    @Test
    public void test() throws InterruptedException {
        Runnable runn = new Runn();
        //2 потоки котрі будуть виконувати 1 і той самий метод з 1ого об'єкту
        Thread t1 = new Thread(runn);
        Thread t2 = new Thread(runn);

        Thread mainThread = Thread.currentThread();
        System.out.println("Main thread  " + mainThread.getName() + " state is " + mainThread.getState());


        //Після створення стейт NEW
        System.out.println("Thread  " + t1.getName() + " state is " + t1.getState());
        System.out.println("Thread  " + t2.getName() + " state is " + t2.getState() + "\n");
        //Після старту потоків стейт RUNNABLE
        t1.start();
        t2.start();
        System.out.println("AFTER START");
        System.out.println("Thread  " + t1.getName() + " state is " + t1.getState());
        System.out.println("Thread  " + t2.getName() + " state is " + t2.getState() + "\n");
        int counter = 0;
        while (counter < 100) {
            counter++;
        }
        System.out.println("AFTER SOME TIME 1");
        System.out.println("Thread  " + t1.getName() + " state is " + t1.getState());
        System.out.println("Thread  " + t2.getName() + " state is " + t2.getState() + "\n");


        // Блокує main потік, поки цей потік не завершиться. Це дозволяє детерміновано дочекатися виконання потоків.
        t2.join();
        System.out.println("AFTER MAIN LOCK TO END 2nd THREAD");
        System.out.println("Thread  " + t2.getName() + " state is " + t2.getState() + "\n");
        System.out.println("Thread  " + t1.getName() + " state is " + t1.getState() + "\n");
        //Якщо буде join() на обох потоках то мейн буде послідовно в порядку який джойн перший чекати на їх завершення


        long counter3 = 0;
        while (counter3 < 1000000000) {
            counter3++;
        }
        System.out.println("AFTER SOME BIG TIME");
        System.out.println("Thread  " + t1.getName() + " state is " + t1.getState());
        System.out.println("Thread  " + t2.getName() + " state is " + t2.getState() + "\n");
    }


}
