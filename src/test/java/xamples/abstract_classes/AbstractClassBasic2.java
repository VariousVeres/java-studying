package xamples.abstract_classes;

import org.testng.annotations.Test;


// абстрактный класс Фігура
abstract class Figure {
    double dim1;
    double dim2;

    Figure(double a, double b) {
        dim1 = a;
        dim2 = b;
    }

    // абстрактний метод для обчисленя площі
    abstract double perimeter();

    public void screamFigure() {
        System.out.println("FIGURE");
    }
}

// Клас Трикутник
class Triangle extends Figure {

    double dim3;
    Triangle(double a, double b, double c) {
        super(a, b);
        this.dim3 = c;
    }

    // перевизначаєм метод
    double perimeter() {
        return dim1 + dim2 + dim3;
    }

}




public class AbstractClassBasic2 {
    @Test
    public void test() {
        // Figure figure = new Figure(10, 10);
        Triangle triangle = new Triangle(10, 8 ,5);
        System.out.println("Периметр " + triangle.perimeter());
        triangle.screamFigure();
    }

}
