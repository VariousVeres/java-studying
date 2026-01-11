package xamples.exceptions;

import org.junit.Test;


class Croco {
    private String name;

    String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class Exceptions {

    private int a = 23;


    private String[] catNames = {"Мурзік", "Барсік", "Калюня"};

    void divide(int b) {
        System.out.println("Отаке значення від ділення - " + (a / b));
    }

    String getCatFromArray(int index) {
        System.out.println("Отаке ім'я котика номер " + (index + 1) + " " + catNames[index]);
        return catNames[index];
    }

    void showCrocoNameLenght(Croco croco) {
        System.out.println("Croco name lenght is - " + croco.getName().length());
    }

    void makeCrocoNameUppercase(Croco croco) throws NullPointerException {
        System.out.println("Croco name lenght is - " + croco.getName().toUpperCase());
    }


    @Test
    public void test() {

        /**Приклад коли система може кинути виключення і ми його ловим**/
        try {
            //Якщо параметр буде 0 то буде ділення на нуль
            divide(1);
            //Якщо індекс буде > 2 то в масиві тільки 3 елемента
            getCatFromArray(2);
        }
        //Після батьківського виключення дочірні вже не зловиш
//        catch (Exception exception)  {
//            System.out.println("Загальне виключення " + exception.getMessage());
//        }

        //Якщо b буде нуль то зловить ArithmeticException
        catch (ArithmeticException arithmeticException) {
            System.out.println("Халепа сталась сталась з діленням: " + arithmeticException.getMessage());
        }
        //Якщо ділення на нуль не буде то зловить ArrayIndexOutOfBoundsException
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            System.out.println("Халепа сталась сталась з доставанням з масиву: " + arrayIndexOutOfBoundsException.getMessage());
        }


        /**Приклад коли ми самі кидаєм виключення **/
        Croco croco = new Croco();
        //Якщо не засетаємо ім'я то буде nullPointer
        croco.setName("Croco name");
        if (croco.getName() == null) {
            throw new IllegalStateException("Кидаємо самі виключення якщо об'єкт буде null");
        } else {
            //Цей метод візьме об'єкт витягне з нього пропертю name яка null і на вичисленні довжини буде виключення
            showCrocoNameLenght(croco);
        }

        /**Приклад коли додаємо throws в сигнатуру метода де може бути виключення**/
        //Той хто викликає цей метод буде бачити що можливе виключення і має його обробити якось
        Croco croco1 = new Croco();
        //Якщо не засетаємо ім'я то буде nullPointer
        croco1.setName("Croco 1 name");
        makeCrocoNameUppercase(croco1);

    }

}
