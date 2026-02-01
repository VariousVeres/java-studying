package tasks;

import org.testng.annotations.Test;

import java.util.Objects;

/**
 * Потрібно
 * Реалізувати equals і hashCode
 * Вирішити:
 * використовуєш instanceof чи getClass()
 * Пояснити:
 * чи можуть Shape і Circle бути рівними?
 * що буде з symmetry:
 * shape.equals(circle)
 * circle.equals(shape)
 * 👉 Це задача не стільки на код, скільки на контракт equals
 **/

class Shape {
    int x;
    int y;

    public boolean equals(Object o) {
        if (this == o) return true;
        //Напевне instanceof якщо ми будем порівнювати з чайлд - буде true тоді
        if (!(o instanceof Shape)) return false;
        //Отак буде false бо в них бдуть різні класи
//        if (o == null || o.getClass() != getClass()) return false;
        Shape shape = (Shape) o;
        return this.x == shape.x && this.y == shape.y;
    }

    public int hashCode() {
        return Objects.hash(this.x, this.y);
    }

}

class Circle extends Shape {
    int radius;
}

class ColoredCircle extends Circle {
    ColoredCircle(int x, int y, int radius, String color) {
        super.x = x;
        super.y = y;
        super.radius = radius;
        this.color = color;
    }

    String color;
}

public class EqualsHashCode2 {
    @Test
    public void test() {
        Shape shape = new Shape();
        Circle circle = new Circle();
        //В такому випадку будуть рівні і так і так бо полів нема ні там ні там
        System.out.println(shape.equals(circle));
        System.out.println(circle.equals(shape));

        Shape shape2 = new Shape();
        shape.x = 1;
        shape.y = 2;

        Circle circle2 = new Circle();
        circle.x = 1;
        circle.y = 2;
        circle.radius = 10;

        System.out.println(shape2.equals(circle2));
        System.out.println(circle2.equals(shape2));


        ColoredCircle c = new ColoredCircle(1, 2, 10, "red");

        System.out.println(shape.equals(c));

    }
}


