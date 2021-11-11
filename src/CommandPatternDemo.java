import java.util.ArrayList;
import java.util.List;

//// 股票(实际执行者)
class Stock {
    private String name = "A";
    private int price = 10000;

    public void buy() {
        info();
        System.out.println("买进!");
    }

    public void sell() {
        info();
        System.out.println("售出!");
    }

    private void info() {
        StringBuilder builder = new StringBuilder();
        builder.append("【").append(name).append("股】");
        builder.append("【").append(price).append("元】");
        System.out.print(builder.toString());
    }
}

//// 命令(接口)
interface Order {
    void execute();
}

//// 买进命令
class BuyOrder implements Order {
    // 引用到真正的执行者
    private Stock stock;

    public BuyOrder(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void execute() {
        stock.buy();
    }
}

//// 售出命令
class SellOrder implements Order {
    // 引用到真正的执行者
    private Stock stock;

    public SellOrder(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void execute() {
        stock.sell();
    }
}

//// 股票交易平台(命令发送者兼命令队列)
class Platform {
    // 命令队列
    private List<Order> orders = new ArrayList<>();

    // 向命令队列中添加命令
    public void prepareOrder(Order order) {
        orders.add(order);
    }

    // 执行命令队列所有命令
    public void completeOrder() {
        for (Order order : orders) {
            order.execute();
        }
        orders.clear();
    }
}

public class CommandPatternDemo {
    public static void main(String[] args) {

        // 新建一支股票
        Stock stock = new Stock();

        // 两个买进命令
        BuyOrder buyOrder1 = new BuyOrder(stock);
        BuyOrder buyOrder2 = new BuyOrder(stock);
        // 一个售出命令
        SellOrder sellOrder = new SellOrder(stock);

        // 用股票交易平台操控命令
        Platform platform = new Platform();
        platform.prepareOrder(buyOrder1);
        platform.prepareOrder(buyOrder2);
        platform.prepareOrder(sellOrder);
        platform.completeOrder();
    }
}
