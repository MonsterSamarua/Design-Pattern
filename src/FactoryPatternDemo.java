////// 三种图形的接口
//interface Shape {
//    void draw();
//}
//
////// 圆形
//class Circle implements Shape {
//    @Override
//    public void draw() {
//        System.out.println("我是一个圆形，我正在画出自己 >_<");
//    }
//}
//
////// 三角形
//class Triangle implements Shape {
//    @Override
//    public void draw() {
//        System.out.println("我是一个三角形，我正在画出自己 >_<");
//    }
//}
//
////// 正方形
//class Square implements Shape {
//    @Override
//    public void draw() {
//        System.out.println("我是一个正方形，我正在画出自己 >_<");
//    }
//}
//
//
////// 图形工厂接口
//interface ShapeFactory {
//    Shape getShape();
//}
//
////// 圆形工厂
//class CircleFactory implements ShapeFactory {
//    @Override
//    public Shape getShape() {
//        return new Circle();
//    }
//}
//
////// 三角形工厂
//class TriangleFactory implements ShapeFactory {
//    @Override
//    public Shape getShape() {
//        return new Triangle();
//    }
//}
//
////// 圆形工厂
//class SquareFactory implements ShapeFactory {
//    @Override
//    public Shape getShape() {
//        return new Square();
//    }
//}
//
//public class FactoryPatternDemo {
//    public static void main(String[] args) {
//
//        // 创建一个圆形工厂
//        ShapeFactory circleFactory = new CircleFactory();
//        // 获取圆形
//        Shape circle1 = circleFactory.getShape();
//        Shape circle2 = circleFactory.getShape();
//        Shape circle3 = circleFactory.getShape();
//
//        // 创建一个三角形工厂
//        ShapeFactory triangleFactory = new TriangleFactory();
//        // 获取圆形
//        Shape triangle1 = triangleFactory.getShape();
//        Shape triangle2 = triangleFactory.getShape();
//        Shape triangle3 = triangleFactory.getShape();
//
//        // 创建一个正方形工厂
//        ShapeFactory squareFactory = new SquareFactory();
//        // 获取圆形
//        Shape square1 = squareFactory.getShape();
//        Shape square2 = squareFactory.getShape();
//        Shape square3 = squareFactory.getShape();
//
//        // 试一试能不能用
//        new CircleFactory().getShape().draw();
//        new TriangleFactory().getShape().draw();
//        new SquareFactory().getShape().draw();
//
//    }
//}
