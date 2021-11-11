import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//// 树
class Tree {
    private int x;
    private int y;
    private int h;
    private Type type;

    public Tree(int x, int y, int h, Type type) {
        this.x = x;
        this.y = y;
        this.h = h;
        this.type = type;
    }

    public void plant() {
        System.out.println("种下一棵树～");
        System.out.println("坐标x: " + x);
        System.out.println("坐标y: " + y);
        System.out.println("高度: " + h);
        System.out.println("颜色: " + type.getColor());
        System.out.println("材质: " + type.getTextrue());
    }
}

//// 享元类
class Type {
    // 依次为绿色、黄色、褐色、黑色
    static final String[] COLORS = {"green", "yellow", "brown", "black"};
    // 依次为杉木、橡木、桦木、槐木
    static final String[] TEXTURES = {"fir", "oak", "birch", "locust"};

    private String color;
    private String textrue;

    public Type(String color, String textrue) {
        this.color = color;
        this.textrue = textrue;
    }

    public String getColor() { return color; }
    public String getTextrue() { return textrue; }
}

//// 享元工厂
class TypeFactory {
    private Map<String, Type> typeCache = new HashMap<>();

    public Type getType(String color, String textrue) {
        String key = color + textrue;
        if (!typeCache.containsKey(key)) {
            typeCache.put(key, new Type(color, textrue));
        }
        return typeCache.get(key);
    }
}

//// 森林
class Forest {
    public List<Tree> trees = new ArrayList<>();

    public void init() {
        TypeFactory typeFactory = new TypeFactory();
        // 搭建1000棵树
        // 每棵树具有随机的位置，随机的高度，随机的颜色，随机的材质
        for (int i = 0; i < 1000; i++) {
            Type type = typeFactory.getType(initColor(), initTexture());
            Tree tree = new Tree(initX(), initY(), initH(), type);
            tree.plant();
            trees.add(tree);
        }
    }

    private int initX() {
        return (int) (Math.random() * 10000);
    }

    private int initY() {
        return (int) (Math.random() * 10000);
    }

    private int initH() {
        return (int) (Math.random() * 10);
    }

    private String initColor() {
        return Type.COLORS[(int) (Math.random() * Type.COLORS.length)];
    }

    private String initTexture() {
        return Type.TEXTURES[(int) (Math.random() * Type.TEXTURES.length)];
    }
}

public class FlyweightPatternDemo {
    public static void main(String[] args) {
        // 初始化森林
        // 即种植树木
        new Forest().init();
    }
}
