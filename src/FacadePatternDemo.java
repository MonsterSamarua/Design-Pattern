///// 电脑组件(接口)
interface ComputerPart {
    void startup();
    void shutdown();
}

//// 处理器
class Cpu implements ComputerPart {
    public void startup() { System.out.println("CPU已启动 ^_^"); }
    public void shutdown() { System.out.println("CPU已关闭 >_<"); }
}
//// 显卡
class Rtx implements ComputerPart {
    public void startup() { System.out.println("显卡已启动 ^_^"); }
    public void shutdown() { System.out.println("显卡已关闭 >_<"); }
}

//// 内存
class Ddr implements ComputerPart {
    public void startup() { System.out.println("内存已启动 ^_^"); }
    public void shutdown() { System.out.println("内存已关闭 >_<"); }
}

//// 硬盘
class Ssd implements ComputerPart {
    public void startup() { System.out.println("硬盘已启动 ^_^"); }
    public void shutdown() { System.out.println("硬盘已关闭 >_<"); }
}


//// 电脑外观
class ComputerFacade {

    private Cpu cpu;
    private Rtx rtx;
    private Ddr ddr;
    private Ssd ssd;

    public ComputerFacade() {
        this.cpu = new Cpu();
        this.rtx = new Rtx();
        this.ddr = new Ddr();
        this.ssd = new Ssd();
    }

    public void startup() {
        System.out.println("电脑开始启动.........");
        cpu.startup();
        rtx.startup();;
        ddr.startup();
        ssd.startup();
        System.out.println("电脑启动完成!!!!!!!!!");
    }

    public void shutdown() {
        System.out.println("电脑开始关闭.........");
        cpu.shutdown();
        rtx.shutdown();
        ddr.shutdown();
        ssd.shutdown();
        System.out.println("电脑关闭完成!!!!!!!!!");
    }
}


public class FacadePatternDemo {
    public static void main(String[] args) {

        // 创建一个电脑外观
        ComputerFacade computerFacade = new ComputerFacade();

        // 开启电脑整机
        computerFacade.startup();
        // 关闭电脑整机
        computerFacade.shutdown();
    }
}
