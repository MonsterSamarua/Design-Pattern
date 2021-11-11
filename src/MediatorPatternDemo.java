import java.util.ArrayList;
import java.util.List;

//// 赌徒
class Gambler {
    // 名字
    private String name;
    // 财产
    private int money;
    // 引用到中介者
    GamblerHouse gamblerHouse;

    public Gambler(String name, int money, GamblerHouse gamblerHouse) {
        this.name = name;
        this.money = money;
        this.gamblerHouse = gamblerHouse;
    }

    public String getName() { return name; }
    public int getMoney() { return money; }
    public void setName(String name) { this.name = name; }
    public void setMoney(int money) { this.money = money; }

    // 通过该方法调用到中介者
    public void changeMoney(int change) {
        gamblerHouse.someoneWin(name, change);
    }
}


//// 赌徒小屋(中介者)
class GamblerHouse {
    // 所有的赌徒对象集合
    List<Gambler> gamblerList = new ArrayList<>();

    // 赌徒通过该方法登记注册
    public void register(Gambler gambler) {
        gamblerList.add(gambler);
    }

    // 作为中介者，协调赌徒间的交互
    public void someoneWin(String name, int change) {
        for (Gambler gambler : gamblerList) {
            if (gambler.getName().equals(name)) {
                gambler.setMoney(gambler.getMoney() + change);
            } else {
                gambler.setMoney(gambler.getMoney() - change);
            }
        }
    }

    // 展示小屋内所有赌徒的信息
    public void showEveryone() {
        for (Gambler gambler : gamblerList) {
            System.out.println("【" + gambler.getName() + "】" + gambler.getMoney());
        }
    }
}

public class MediatorPatternDemo {
    public static void main(String[] args) {

        // 创建一个赌徒小屋(中介者)
        GamblerHouse gamblerHouse = new GamblerHouse();

        // 创建多个赌徒对象
        Gambler A = new Gambler("A", 10000, gamblerHouse);
        Gambler B = new Gambler("B", 20000, gamblerHouse);
        Gambler C = new Gambler("C", 30000, gamblerHouse);
        // 赌徒在赌徒小屋进行登记
        gamblerHouse.register(A);
        gamblerHouse.register(B);
        gamblerHouse.register(C);

        // 赌徒小屋作为中介者，协调赌徒间的交互
        gamblerHouse.showEveryone();
        A.changeMoney(8000);
        gamblerHouse.showEveryone();
    }
}
