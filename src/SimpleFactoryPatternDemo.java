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
////// 图形工厂
//class ShapeFactory {
//    public Shape getShape(String shapeType) {
//        if (shapeType == null) {
//            return null;
//        } else if (shapeType.equals("CIRCLE")) {
//            return new Circle();
//        } else if (shapeType.equals("TRIANGLE")) {
//            return new Triangle();
//        } else if (shapeType.equals("SQUARE")) {
//            return new Square();
//        }
//        return null;
//    }
//}
//
//public class SimpleFactoryPatternDemo {
//    public static void main(String[] args) {
//
//        // 先创建一个工厂
//        ShapeFactory shapeFactory = new ShapeFactory();
//
//        // 获取Circle对象，并调用draw()方法
//        Shape shape1 = shapeFactory.getShape("CIRCLE");
//        shape1.draw();
//
//        // 获取Triangle对象，并调用draw()方法
//        Shape shape2 = shapeFactory.getShape("TRIANGLE");
//        shape2.draw();
//
//        // 获取Square对象，并调用draw()方法
//        Shape shape3 = shapeFactory.getShape("SQUARE");
//        shape3.draw();
//
//    }
//}