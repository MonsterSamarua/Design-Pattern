//// 游戏角色(抽象类)
abstract class Character {
    // 模板方法
    // 这是一个算法骨架
    public final void behavior() {
        eat();
        fight();
        sleep();
    }

    // 留给子类实现的扩展点
    public abstract void eat();
    public abstract void fight();
    public abstract void sleep();
}

//// 人类
class Human extends Character {

    @Override
    public void eat() {
        System.out.println("什么都吃 ^_^");
    }

    @Override
    public void fight() {
        System.out.println("使用铁剑进行战斗 ^_^");
    }

    @Override
    public void sleep() {
        System.out.println("在床上呼呼大睡 ^_^");
    }
}

//// 恶龙
class Dragon extends Character {

    @Override
    public void eat() {
        System.out.println("吃森林里的浆果 >_<");
    }

    @Override
    public void fight() {
        System.out.println("喷出火焰进行战斗 >_<");
    }

    @Override
    public void sleep() {
        System.out.println("睡在火上顶的巢穴里 >_<");
    }
}

public class TemplatePatternDemo {
    public static void main(String[] args) {

        // 创建一个人类
        Character human = new Human();
        // 调用人类的模板方法
        human.behavior();

        // 创建一个恶龙
        Character dragon = new Dragon();
        // 调用恶龙的模板方法
        dragon.behavior();
    }
}