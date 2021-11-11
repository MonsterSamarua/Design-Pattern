//// 三种图形的接口
interface Shape {
    void draw();
}

//// 圆形
interface Circle extends Shape { }

//// 正方形
interface Square extends Shape { }

//// 三角形
interface Triangle extends Shape { }


//// [红色｜蓝色｜绿色][圆形｜正方形｜三角形]
class RedCircle implements Circle { @Override public void draw() { System.out.println("我是红色的圆形 >_<"); }}
class BlueCircle implements Circle { @Override public void draw() { System.out.println("我是蓝色的圆形 >_<"); }}
class GreenCircle implements Circle { @Override public void draw() { System.out.println("我是绿色的圆形 >_<"); }}
class RedSquare implements Square { @Override public void draw() { System.out.println("我是红色的正方形 >_<"); }}
class BlueSquare implements Square { @Override public void draw() { System.out.println("我是蓝色的正方形 >_<"); }}
class GreenSquare implements Square { @Override public void draw() { System.out.println("我是绿色的正方形 >_<"); }}
class RedTriangle implements Triangle { @Override public void draw() { System.out.println("我是红色的三角形 >_<"); }}
class BlueTriangle implements Triangle { @Override public void draw() { System.out.println("我是蓝色的三角形 >_<"); }}
class GreenTriangle implements Triangle { @Override public void draw() { System.out.println("我是绿色的三角形 >_<"); }}


//// 抽象工厂接口
interface AbstractFactory {
    Shape getCircle();
    Shape getSquare();
    Shape getTriangle();
}

//// 红色图形工厂
class RedFactory implements AbstractFactory {

    @Override
    public Shape getCircle() {
        return new RedCircle();
    }

    @Override
    public Shape getSquare() {
        return new RedSquare();
    }

    @Override
    public Shape getTriangle() {
        return new RedTriangle();
    }
}

//// 蓝色图形工厂
class BlueFactory implements AbstractFactory {

    @Override
    public Shape getCircle() {
        return new BlueCircle();
    }

    @Override
    public Shape getSquare() {
        return new BlueSquare();
    }

    @Override
    public Shape getTriangle() {
        return new BlueTriangle();
    }
}

//// 绿色图形工厂
class GreenFactory implements AbstractFactory {

    @Override
    public Shape getCircle() {
        return new GreenCircle();
    }

    @Override
    public Shape getSquare() {
        return new GreenSquare();
    }

    @Override
    public Shape getTriangle() {
        return new GreenTriangle();
    }
}

public class AbstractFactoryPatternDemo {
    public static void main(String[] args) {

        // 创建一个红色图形工厂
        AbstractFactory redFactory = new RedFactory();
        // 生产的图形是成套的红色
        redFactory.getCircle().draw();
        redFactory.getSquare().draw();
        redFactory.getTriangle().draw();

        // 创建一个蓝色图形工厂
        AbstractFactory blueFactory = new BlueFactory();
        // 生产的图形是成套的蓝色
        blueFactory.getCircle().draw();
        blueFactory.getSquare().draw();
        blueFactory.getTriangle().draw();

        // 创建一个绿色图形工厂
        AbstractFactory greenFactory = new GreenFactory();
        // 生产的图形是成套的绿色
        greenFactory.getCircle().draw();
        greenFactory.getSquare().draw();
        greenFactory.getTriangle().draw();

    }
}
