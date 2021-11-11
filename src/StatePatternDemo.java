//// 状态(抽象类)
abstract class State {
    protected MusicPlayer musicPlayer;

    public State(MusicPlayer musicPlayer) {
        this.musicPlayer = musicPlayer;
    }

    public abstract void clickLock();
    public abstract void clickPlay();
    public abstract void clickPrev();
    public abstract void clickNext();
}

//// 锁定状态
class LockedState extends State {
    public LockedState(MusicPlayer musicPlayer) {
        super(musicPlayer);
    }

    @Override
    public void clickLock() {
        System.out.println("已解锁播放器！");
        musicPlayer.changeState(new ReadyState(musicPlayer));
    }

    @Override
    public void clickPlay() {
        System.out.println("无效操作，因为播放器已锁定 >_<");
    }

    @Override
    public void clickPrev() {
        System.out.println("无效操作，因为播放器已锁定 >_<");
    }

    @Override
    public void clickNext() {
        System.out.println("无效操作，因为播放器已锁定 >_<");
    }
}

//// 就绪状态
class ReadyState extends State {
    public ReadyState(MusicPlayer musicPlayer) {
        super(musicPlayer);
    }

    @Override
    public void clickLock() {
        System.out.println("已锁定播放器！");
        musicPlayer.changeState(new LockedState(musicPlayer));
    }

    @Override
    public void clickPlay() {
        System.out.println("播放音乐～");
        musicPlayer.changeState(new PlayingState(musicPlayer));
    }

    @Override
    public void clickPrev() {
        System.out.println("无效操作，因为没有播放记录 >_<");
    }

    @Override
    public void clickNext() {
        System.out.println("无效操作，因为没有播放记录 >_<");
    }
}

//// 播放中状态
class PlayingState extends State {
    public PlayingState(MusicPlayer musicPlayer) {
        super(musicPlayer);
    }

    @Override
    public void clickLock() {
        System.out.println("已锁定播放器！");
        musicPlayer.changeState(new LockedState(musicPlayer));
    }

    @Override
    public void clickPlay() {
        System.out.println("暂停音乐～");
        musicPlayer.changeState(new ReadyState(musicPlayer));
    }

    @Override
    public void clickPrev() {
        System.out.println("正在播放上一首音乐...");
    }

    @Override
    public void clickNext() {
        System.out.println("正在播放下一首音乐...");
    }
}


//// 音乐播放器
class MusicPlayer {
    // 默认处于锁定状态
    private State state = new LockedState(this);

    // 获取当前状态
    public State getCurrentState() {
        return state;
    }

    // 进行状态转化
    public void changeState(State state) {
        this.state = state;
    }
}


public class StatePatternDemo {
    public static void main(String[] args) {

        // 获得一个音乐播放器
        MusicPlayer musicPlayer = new MusicPlayer();

        // 进行一系列动作
        // 并同时进行着状态的转化
        musicPlayer.getCurrentState().clickPlay();
        musicPlayer.getCurrentState().clickLock();
        musicPlayer.getCurrentState().clickPrev();
        musicPlayer.getCurrentState().clickNext();
        musicPlayer.getCurrentState().clickPlay();
        musicPlayer.getCurrentState().clickPrev();
        musicPlayer.getCurrentState().clickNext();
        musicPlayer.getCurrentState().clickPlay();
        musicPlayer.getCurrentState().clickLock();
    }
}
