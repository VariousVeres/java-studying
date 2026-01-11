package xamples.abstract_classes;

import org.junit.Test;


// абстрактный класс Фигура
abstract class Figure {
    double dim1;
    double dim2;

    Figure(double a, double b) {
        dim1 = a;
        dim2 = b;
    }

    // абстрактный метод для вычисления площади
    abstract double area();
}

// Клас Треугольник
class Triangle extends Figure {
    Triangle(double a, double b) {
        super(a, b);
    }

    // переопределяем метод
    double area() {
        return dim1 * dim2 / 2;
    }

}


public class AbstractClass2 {
    @Test
    public void test() {
        // Figure figure = new Figure(10, 10); // так нельзя
        Triangle triangle = new Triangle(10, 8);

        Figure figure; // так можно, так как объект мы не создаем
        figure = triangle;
        System.out.println("Площадь равна " + figure.area());
    }

}
