package examples.design_patterns;


import org.junit.Test;

interface Shape {
    void draw();
}

class Circle1 implements Shape {
    public void draw() {
        System.out.println("Draw circle 1");
    }
}

class Circle2 implements Shape {
    public void draw() {
        System.out.println("Draw circle 2");
    }
}

abstract class ShapeDecorator implements Shape {
    Shape shape;
    ShapeDecorator(Shape s) {
        this.shape = s;
    }
    public void draw() {
        shape.draw();
    }
}

class RedShapeDecorator extends ShapeDecorator  {
    RedShapeDecorator(Shape s)  {
        super(s);
    }

    void drawRed()  {
        System.out.println("Draw red");
    }
}


public class Decorator  {
    @Test
    public void main()  {
        Shape c1 = new Circle1();
        c1.draw();
        RedShapeDecorator rS = new RedShapeDecorator(c1);
        rS.draw();
        rS.drawRed();
    }

}


