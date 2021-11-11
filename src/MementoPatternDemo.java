import java.util.ArrayDeque;
import java.util.Deque;

//// 游戏
class Game {
    // 版本信息
    private int versionId;
    private String versionName;

    public void setVersionId(int versionId) { this.versionId = versionId; }
    public void setVersionName(String versionName) { this.versionName = versionName; }

    // 生成版本快照（关键）
    public Version createVersion() {
        return new Version(this, versionId, versionName);
    }

    public void showVersion() {
        System.out.println("【" + versionId + "】" + versionName);
    }
}

//// 游戏版本
class Version {
    // 指向原对象的引用
    Game game;
    // 用于回退原对象版本的信息
    private int versionId;
    private String versionName;

    public Version(Game game, int versionId, String versionName) {
        this.game = game;
        this.versionId = versionId;
        this.versionName = versionName;
    }

    // 回退原对象版本（关键）
    public void rollbackVersion() {
        game.setVersionId(versionId);
        game.setVersionName(versionName);
    }
}

//// 游戏版本历史记录
class VersionHistory {
    // 这是一个栈数据结构
    private Deque<Version> versionStack = new ArrayDeque<>();

    // 某一版本入栈
    public void push(Version version) {
        versionStack.push(version);
    }

    // 出栈某一版本
    public Version pop() {
        return versionStack.pop();
    }
}

public class MementoPatternDemo {
    public static void main(String[] args) {

        // 创建一个游戏对象(原对象)
        Game game = new Game();
        // 创建一个游戏版本历史记录对象(备忘录历史记录对象)
        VersionHistory versionHistory = new VersionHistory();

        // 设置当前游戏版本，并将版本快照(备忘录)入栈
        game.setVersionId(100);
        game.setVersionName("version-100");
        game.showVersion();
        versionHistory.push(game.createVersion());

        // 设置当前游戏版本，并将版本快照(备忘录)入栈
        game.setVersionId(200);
        game.setVersionName("version-200");
        game.showVersion();
        versionHistory.push(game.createVersion());

        // 设置当前游戏版本，并将版本快照(备忘录)入栈
        game.setVersionId(300);
        game.setVersionName("version-300");
        game.showVersion();
        versionHistory.push(game.createVersion());

        // 版本快照(备忘录)出栈，用于回退游戏版本
        versionHistory.pop().rollbackVersion();
        game.showVersion();

        // 版本快照(备忘录)出栈，用于回退游戏版本
        versionHistory.pop().rollbackVersion();
        game.showVersion();

        // 版本快照(备忘录)出栈，用于回退游戏版本
        versionHistory.pop().rollbackVersion();
        game.showVersion();
    }
}
