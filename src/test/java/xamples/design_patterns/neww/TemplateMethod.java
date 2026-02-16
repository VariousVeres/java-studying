package xamples.design_patterns.neww;

import org.testng.annotations.Test;

/**
 * Створи абстрактний клас HotBeverage
 * final void prepare()
 * Цей метод:
 * викликає кроки у правильному порядку
 * є шаблоном алгоритму
 * 2️⃣ Усередині класу
 * <p>
 * Реалізуй:
 * void boilWater()
 * void pourInCup()
 * І один абстрактний метод:
 * protected abstract void brew();
 * (заварювання буде різним)
 * 3️⃣ Створи два підкласи
 * Tea
 * Реалізує brew()
 * Coffee
 * Реалізує brew()
 * Можеш додатково зробити:
 * protected abstract void addCondiments();
 * І реалізувати по-різному.
 * 📌 Використання
 * У тесті або main:
 * HotBeverage beverage = new Tea();
 * beverage.prepare();
 *
 * HotBeverage beverage = new Coffee();
 * beverage.prepare();
 **/

abstract class HotBeverage {

    final public void prepare() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    void boilWater() {
        System.out.println("Boil water");
    }

    void pourInCup() {
        System.out.println("Pour in cup");
    }

    abstract void brew();

    abstract void addCondiments();

}


class Coffee extends HotBeverage {

    @Override
    void brew() {
        System.out.println("Brew [coffee]");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Add кориця");
    }
}

class Tee extends HotBeverage {

    @Override
    void brew() {
        System.out.println("Brew [tea]");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Add цукор");
    }
}

class Matcha extends HotBeverage {

    @Override
    void brew() {
        System.out.println("Brew [matcha]");
    }

    @Override
    void addCondiments() {
        System.out.println("В матчу нічого не даєм");
    }

}

public class TemplateMethod {
    @Test
    public void test() {
        Tee tea = new Tee();
        tea.prepare();
        System.out.println("------------");
        Coffee coffee = new Coffee();
        coffee.prepare();
        System.out.println("------------");
        Matcha matcha = new Matcha();
        matcha.prepare();



    }
}
