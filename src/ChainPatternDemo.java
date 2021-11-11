//// 领导(抽象类)
abstract class Leader {
    // 权力
    protected int power;
    // 下一个处理者
    private Leader nextLeader;

    public void setNextLeader(Leader leader) {
        nextLeader = leader;
    }

    public Leader getNextLeader() {
        return nextLeader;
    }

    public void handle(int level) {
        if (power >= level) {
            System.out.println("我已经处理了这件事情（^_^）");
        } else if (this.getNextLeader() != null) {
            System.out.println("我处理不了这件事情，但我把它汇报给了上级（>_<）");
            this.getNextLeader().handle(level);
        } else {
            System.out.println("这件事情没有得到解决（#_#）");
        }
    }
}


//// 助理
class Aid extends Leader {
    public Aid() {
        this.power = 2;
    }

    @Override
    public void handle(int level) {
        System.out.println("我是助理");
        super.handle(level);
    }
}

//// 主任
class Dean extends Leader {
    public Dean() {
        this.power = 6;
    }

    @Override
    public void handle(int level) {
        System.out.println("我是主任");
        super.handle(level);
    }
}

//// 校长
class Master extends Leader {
    public Master() {
        this.power = 10;
    }

    @Override
    public void handle(int level) {
        System.out.println("我是校长");
        super.handle(level);
    }
}


public class ChainPatternDemo {
    public static void main(String[] args) {

        // 生成几个领导对象
        Leader aid = new Aid();
        Leader dean = new Dean();
        Leader master = new Master();

        // 组成责任链
        aid.setNextLeader(dean);
        dean.setNextLeader(master);

        // 请求放到责任链上
        aid.handle(9);
    }
}
