//// 设备(接口)
interface Device {
    int getVolume();
    int getChannel();
    void setVolume(int volume);
    void setChannel(int channel);
}

//// 收音机
class Radio implements Device {

    private int volume = 20;
    private int channel = 1;

    @Override public int getVolume() { return volume; }

    @Override public int getChannel() { return channel; }

    @Override public void setVolume(int volume) { this.volume = volume; }

    @Override public void setChannel(int channel) { this.channel = channel; }
}

//// 电视
class Tv implements Device {

    private int volume = 30;
    private int channel = 1;

    @Override public int getVolume() { return volume; }

    @Override public int getChannel() { return channel; }

    @Override public void setVolume(int volume) { this.volume = volume; }

    @Override public void setChannel(int channel) { this.channel = channel; }
}


//// 遥控器(抽象基类)
abstract class RemoteController {

    protected Device device;

    protected RemoteController(Device device) {
        this.device = device;
    }

    public abstract void volumeUp();
    public abstract void volumeDown();
    public abstract void channelUp();
    public abstract void channelDown();

    public abstract void showVolume();
    public abstract void showChannel();
}

//// 遥控器A类型
class RemoteControllerA extends RemoteController {

    protected RemoteControllerA(Device device) {
        super(device);
    }

    @Override
    public void volumeUp() {
        device.setVolume(device.getVolume() + 10);
    }

    @Override
    public void volumeDown() {
        device.setVolume(device.getVolume() - 10);
    }

    @Override
    public void channelUp() {
        device.setChannel(device.getChannel() + 1);
    }

    @Override
    public void channelDown() {
        device.setChannel(device.getChannel() - 1);
    }

    @Override
    public void showVolume() {
        System.out.println("音量：" + device.getVolume());
    }

    @Override
    public void showChannel() {
        System.out.println("频道：" + device.getChannel());
    }
}

//// 遥控器B类型
class RemoteControllerB extends RemoteController {

    protected RemoteControllerB(Device device) {
        super(device);
    }

    @Override
    public void volumeUp() {
        device.setVolume(device.getVolume() + 15);
    }

    @Override
    public void volumeDown() {
        device.setVolume(device.getVolume() - 15);
    }

    @Override
    public void channelUp() {
        device.setChannel(device.getChannel() + 2);
    }

    @Override
    public void channelDown() {
        device.setChannel(device.getChannel() - 2);
    }

    @Override
    public void showVolume() {
        System.out.println("音量：" + device.getVolume());
    }

    @Override
    public void showChannel() {
        System.out.println("频道：" + device.getChannel());
    }
}

public class BridgePatternDemo {
    public static void main(String[] args) {

        // 新建一个遥控器(类型A)，同时桥接上一个设备(收音机)
        RemoteControllerA remoteControllerA = new RemoteControllerA(new Radio());
        // 用遥控器调低音量试试！
        remoteControllerA.showVolume();
        remoteControllerA.volumeDown();
        remoteControllerA.showVolume();

        // 新建一个遥控器(类型B)，同时桥接上一个设备(电视)
        RemoteControllerB remoteControllerB = new RemoteControllerB(new Tv());
        // 用遥控器增加频道试试！
        remoteControllerB.showChannel();
        remoteControllerB.channelUp();
        remoteControllerB.showChannel();

    }
}
