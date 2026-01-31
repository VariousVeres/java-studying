package xamples.threads;

import org.testng.annotations.Test;

class OldThread extends Thread {

}

class OldThreadNormal extends Thread {
    private volatile boolean running = true;

    @Override
    public void run() {
        while (running) {
            System.out.println("######### " + this.getName() + " thread is running" +" #########");
        }
    }

    //“shutdown через volatile flag — це кооперативна зупинка,
    // тому потік переходить у TERMINATED тільки після завершення run(). Для детермінованості треба використовувати join().”

    public void shutdown() {
        running = false;
    }
}

public class Threading {
    @Test
    public void badExample() throws InterruptedException {
        /**Поганий приклад**/
        Thread oldThread1 = new OldThread();
        Thread oldThread2 = new OldThread();
        //Після створення стейт NEW
        System.out.println("Thread  " + oldThread1.getName() + " state is " + oldThread1.getState());
        System.out.println("Thread  " + oldThread2.getName() + " state is " + oldThread2.getState() + "\n");
        //Після запуску стейт RUNNABLE
        oldThread1.start();
        oldThread2.start();
        System.out.println("Thread  " + oldThread1.getName() + " state is " + oldThread1.getState());
        System.out.println("Thread  " + oldThread2.getName() + " state is " + oldThread2.getState() + "\n");
        //Тут ми примусово зупиняємо 1ий потік але насправді Java вже могла зупитити обидва потоки, а могла й не завершити. Це погана практика.
        oldThread1.stop();
        System.out.println("Thread  " + oldThread1.getName() + " state is " + oldThread1.getState());
        System.out.println("Thread  " + oldThread2.getName() + " state is " + oldThread2.getState() + "\n");
        //Тут ми примусово зупиняємо 2ий потік але насправді Java вже могла зупитити обидва потоки, а могла й не завершити. Це погана практика.
        oldThread2.stop();
        System.out.println("Thread  " + oldThread1.getName() + " state is " + oldThread1.getState());
        System.out.println("Thread  " + oldThread2.getName() + " state is " + oldThread2.getState() + "\n");
    }

    @Test
    public void goodExampleWithoutJoin() {
        /**Нормальний приклад**/

        OldThreadNormal oldThreadNormal1 = new OldThreadNormal();
        OldThreadNormal oldThreadNormal2 = new OldThreadNormal();
        //Після створення стейт NEW
        System.out.println("Thread  " + oldThreadNormal1.getName() + " state is " + oldThreadNormal1.getState());
        System.out.println("Thread  " + oldThreadNormal2.getName() + " state is " + oldThreadNormal2.getState() + "\n");

        oldThreadNormal1.start();
        oldThreadNormal2.start();
        System.out.println("AFTER START");
        System.out.println("Thread  " + oldThreadNormal1.getName() + " state is " + oldThreadNormal1.getState());
        System.out.println("Thread  " + oldThreadNormal2.getName() + " state is " + oldThreadNormal2.getState() + "\n");
        int counter = 0;
        while (counter < 100) {
            counter++;
        }
        System.out.println("AFTER SOME TIME 1");
        System.out.println("Thread  " + oldThreadNormal1.getName() + " state is " + oldThreadNormal1.getState());
        System.out.println("Thread  " + oldThreadNormal2.getName() + " state is " + oldThreadNormal2.getState() + "\n");

        //НЕ зупиняє потік миттєво, а просить його завершитись
        oldThreadNormal1.shutdown();
        oldThreadNormal2.shutdown();

        System.out.println("AFTER SHUTDOWN");
        System.out.println("Thread  " + oldThreadNormal1.getName() + " state is " + oldThreadNormal1.getState());
        System.out.println("Thread  " + oldThreadNormal2.getName() + " state is " + oldThreadNormal2.getState() + "\n");

        int counter1 = 0;
        while (counter1 < 100000) {
            counter1++;
        }
        System.out.println("AFTER SOME BIGGER TIME ");
        System.out.println("Thread  " + oldThreadNormal1.getName() + " state is " + oldThreadNormal1.getState());
        System.out.println("Thread  " + oldThreadNormal2.getName() + " state is " + oldThreadNormal2.getState() + "\n");


        long counter3 = 0;
        while (counter3 < 1000000000) {
            counter3++;
        }
        System.out.println("AFTER SOME BIG TIME");
        System.out.println("Thread  " + oldThreadNormal1.getName() + " state is " + oldThreadNormal1.getState());
        System.out.println("Thread  " + oldThreadNormal2.getName() + " state is " + oldThreadNormal2.getState() + "\n");
    }

    @Test
    public void goodExampleWithtJoin() throws InterruptedException {
        /**Нормальний приклад**/

        Thread mainThread = Thread.currentThread();
        System.out.println("Main thread  " + mainThread.getName() + " state is " + mainThread.getState());

        OldThreadNormal oldThreadNormal1 = new OldThreadNormal();
        OldThreadNormal oldThreadNormal2 = new OldThreadNormal();
        //Після створення стейт NEW
        System.out.println("Thread  " + oldThreadNormal1.getName() + " state is " + oldThreadNormal1.getState());
        System.out.println("Thread  " + oldThreadNormal2.getName() + " state is " + oldThreadNormal2.getState() + "\n");

        oldThreadNormal1.start();
        oldThreadNormal2.start();
        System.out.println("AFTER START");
        System.out.println("Thread  " + oldThreadNormal1.getName() + " state is " + oldThreadNormal1.getState());
        System.out.println("Thread  " + oldThreadNormal2.getName() + " state is " + oldThreadNormal2.getState() + "\n");
        int counter = 0;
        while (counter < 100) {
            counter++;
        }
        System.out.println("AFTER SOME TIME 1");
        System.out.println("Thread  " + oldThreadNormal1.getName() + " state is " + oldThreadNormal1.getState());
        System.out.println("Thread  " + oldThreadNormal2.getName() + " state is " + oldThreadNormal2.getState() + "\n");

        int counter1 = 0;
        while (counter1 < 200000) {
            counter1++;
        }
//        //НЕ зупиняє потік миттєво, а просить його завершитись
        oldThreadNormal1.shutdown();
        oldThreadNormal2.shutdown();

        System.out.println("AFTER SHUTDOWN");
        System.out.println("Thread  " + oldThreadNormal1.getName() + " state is " + oldThreadNormal1.getState());
        System.out.println("Thread  " + oldThreadNormal2.getName() + " state is " + oldThreadNormal2.getState() + "\n");

        // Блокує main потік, поки цей потік не завершиться. Це дозволяє детерміновано дочекатися виконання потоків.
        oldThreadNormal2.join();
        System.out.println("AFTER MAIN LOCK TO END 2nd THREAD");
        System.out.println("Thread  " + oldThreadNormal2.getName() + " state is " + oldThreadNormal2.getState() + "\n");
        System.out.println("Thread  " + oldThreadNormal1.getName() + " state is " + oldThreadNormal1.getState() + "\n");
        //Якщо буде join() на обох потоках то мейн буде послідовно в порядку який джойн перший чекати на їх завершення


        long counter3 = 0;
        while (counter3 < 1000000000) {
            counter3++;
        }
        System.out.println("AFTER SOME BIG TIME");
        System.out.println("Thread  " + oldThreadNormal1.getName() + " state is " + oldThreadNormal1.getState());
        System.out.println("Thread  " + oldThreadNormal2.getName() + " state is " + oldThreadNormal2.getState() + "\n");
    }

}
