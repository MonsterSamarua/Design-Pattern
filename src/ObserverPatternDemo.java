import java.util.ArrayList;
import java.util.List;

//// 观察者(接口)
interface Observer {
    void update(int num);
}

//// 二进制观察者
class BinObserver implements Observer {
    @Override
    public void update(int num) {
        System.out.println("Bin string: " + Integer.toBinaryString(num));
    }
}

//// 八进制观察者
class OctObserver implements Observer {
    @Override
    public void update(int num) {
        System.out.println("Oct string: " + Integer.toOctalString(num));
    }
}

//// 十六进制观察者
class HexObserver implements Observer {
    @Override
    public void update(int num) {
        System.out.println("Hex string: " + Integer.toHexString(num));
    }
}


//// 数字牌(被观察者)
class NumberCard {
    // 数字
    private int num;
    // 观察者列表
    private List<Observer> observerList = new ArrayList<>();

    // 设置数字的同时，通知观察者们
    public void setNum(int num) {
        this.num = num;
        notifyObservers();
    }

    // 向观察者列表中添加观察者
    public void attachObserver(Observer observer) {
        observerList.add(observer);
    }

    // 通知观察者列表中的所有观察者
    public void notifyObservers() {
        for (Observer observer : observerList) {
            observer.update(num);
        }
    }
}

public class ObserverPatternDemo {
    public static void main(String[] args) {

        // 创建二/八/十六进制观察者
        Observer binObserver = new BinObserver();
        Observer octObserver = new OctObserver();
        Observer hexObserver = new HexObserver();

        // 创建数字牌(被观察者)
        NumberCard numberCard = new NumberCard();
        // 注册观察者
        numberCard.attachObserver(binObserver);
        numberCard.attachObserver(octObserver);
        numberCard.attachObserver(hexObserver);

        // 给被观察者设置数字的同时，所有观察者都会得到通知
        numberCard.setNum(10);
        numberCard.setNum(8080);
    }
}
