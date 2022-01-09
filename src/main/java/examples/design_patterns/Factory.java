package examples.design_patterns;

import org.junit.Test;

/**Інтрфейс загальний для фігури**/
interface Figure {
    void draw();

    enum FigureType {
        SQUARE, TRIANGLE, ROUND;
    }
}

/**Класи, які імплементять**/
class Square implements Figure {
    @Override
    public void draw() {
        System.out.println("I am square");
    }
}

class Triangle implements Figure {
    @Override
    public void draw() {
        System.out.println("I am triangle");
    }
}

class Round implements Figure {
    @Override
    public void draw() {
        System.out.println("I am round");
    }
}

/**Клас, який має фабричний метод, який повертає інстанс того типу що треба**/
class FigureFactory {
    public Figure createFigure(Figure.FigureType type) {
        if (type.equals(Figure.FigureType.ROUND)) {
            return new Round();
        } else if (type.equals(Figure.FigureType.SQUARE)) {
            return new Square();
        } else if (type.equals(Figure.FigureType.TRIANGLE)) {
            return new Triangle();
        } else return null;
    }
}

/**Хочем квадрат, хочем трикутник - нема проблем**/
public class Factory {
    @Test
    public void main() {
        FigureFactory creation = new FigureFactory();
        Figure round = creation.createFigure(Figure.FigureType.ROUND);
        Figure square = creation.createFigure(Figure.FigureType.SQUARE);
        round.draw();
        square.draw();
    }

}
