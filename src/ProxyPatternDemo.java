//// 支付方式接口
interface Payment {
    void pay(int money);
    void save(int money);
}

//// 现金
class Cash implements Payment {
    private int total = 10000;

    @Override
    public void pay(int money) {
        total -= money;
        System.out.println("付钱ing");
        System.out.println("当前总金额: " + total);
    }

    @Override
    public void save(int money) {
        total += money;
        System.out.println("存钱ing");
        System.out.println("当前总金额: " + total);
    }
}

//// 银行卡
class Card implements Payment {
    // 对该现金对象进行代理
    private Cash cash;

    public Card(Cash cash) {
        this.cash = cash;
    }

    @Override
    public void pay(int money) {
        preCheck();
        cash.pay(money);
        postCheck();
    }

    @Override
    public void save(int money) {
        preCheck();
        cash.save(money);
        postCheck();
    }

    private void preCheck() {
        System.out.println("现已开启安全保护检查");
    }

    private void postCheck() {
        System.out.println("现已关闭安全保护检查");
    }
}


public class ProxyPatternDemo {
    public static void main(String[] args) {

        // 获得一捆现金
        Cash cash = new Cash();
        // 用银行卡对现金进行代理
        Card card = new Card(cash);

        // 用卡付钱
        card.pay(3000);
        // 用卡存钱
        card.save(8000);
    }
}
