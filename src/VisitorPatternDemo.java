//// 小动物们的家(接口)
interface Animal {
    void accept(AnimalVisitor animalVisitor);
}

//// 小青蛙的家
class Frog implements Animal {
    @Override
    public void accept(AnimalVisitor animalVisitor) {
        animalVisitor.visit(this);
    }
}

//// 小鸭子的家
class Duck implements Animal {
    @Override
    public void accept(AnimalVisitor animalVisitor) {
        animalVisitor.visit(this);
    }
}

//// 小乌鸦的家
class Crow implements Animal {
    @Override
    public void accept(AnimalVisitor animalVisitor) {
        animalVisitor.visit(this);
    }
}

//// 小鼹鼠的家
class Mole implements Animal {
    @Override
    public void accept(AnimalVisitor animalVisitor) {
        animalVisitor.visit(this);
    }
}


//// 森林的访问者
class AnimalVisitor {

    void visit(Frog frog) {
        System.out.println("我来拜访你了，小青蛙 >_< ！！！");
    }

    void visit(Duck duck) {
        System.out.println("我来拜访你了，小鸭子 >_< ！！！");
    }

    void visit(Crow crow) {
        System.out.println("我来拜访你了，小乌鸦 >_< ！！！");
    }

    void visit(Mole mole) {
        System.out.println("我来拜访你了，小鼹鼠 >_< ！！！");
    }
}


public class VisitorPatternDemo {
    public static void main(String[] args) {

        // 森林里来一个不速之客
        AnimalVisitor animalVisitor = new AnimalVisitor();

        // 小青蛙接待了ta
        Frog frog = new Frog();
        frog.accept(animalVisitor);

        // 小鸭子接待了ta
        Duck duck = new Duck();
        duck.accept(animalVisitor);

        // 小乌鸦接待了ta
        Crow crow = new Crow();
        crow.accept(animalVisitor);

        // 小鼹鼠接待了ta
        Mole mole = new Mole();
        mole.accept(animalVisitor);
    }
}
