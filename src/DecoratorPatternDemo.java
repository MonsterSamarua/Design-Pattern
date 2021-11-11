//// 萝莉(接口)
interface Loli {
    void introduce();
}

//// 爱丽丝(萝莉的普通实现类)
class Alice implements Loli {
    private String name = "Alice";

    @Override
    public void introduce() {
        System.out.println("我的名字是" + name + "～");
    }
}


//// 修饰器(给萝莉穿上不同的衣服)
abstract class LoliClothing implements Loli {
    // 一个指向萝莉对象的成员变量(关键)
    // 这个成员变量等待着被传入的参数赋值
    private Loli loli;

    public LoliClothing(Loli loli) {
        this.loli = loli;
    }

    @Override
    public void introduce() {
        loli.introduce();
    }
}

//// 换装———哥特萝莉
class GothClothing extends LoliClothing {

    public GothClothing(Loli loli) {
        super(loli);
    }

    // 萝莉对象的方法得到增强
    @Override
    public void introduce() {
        super.introduce();
        dress();
    }

    private void dress() {
        System.out.println("我是一只哥特萝莉>_<");
    }
}

//// 换装———猫耳萝莉
class NekoClothing extends LoliClothing {

    public NekoClothing(Loli loli) {
        super(loli);
    }

    // 萝莉对象的方法得到增强
    @Override
    public void introduce() {
        super.introduce();
        dress();
    }

    private void dress() {
        System.out.println("我是一只猫耳萝莉>_<");
    }
}

//// 换装———泳装萝莉
class SwimClothing extends LoliClothing {

    public SwimClothing(Loli loli) {
        super(loli);
    }

    // 萝莉对象的方法得到增强
    @Override
    public void introduce() {
        super.introduce();
        dress();
    }

    private void dress() {
        System.out.println("我是一只泳装萝莉>_<");
    }
}

public class DecoratorPatternDemo {
    public static void main(String[] args) {

        // 捕获一只原生萝莉
        Loli alice = new Alice();

        // 换装———哥特萝莉
        GothClothing gothClothingLoli = new GothClothing(alice);
        gothClothingLoli.introduce();

        // 换装———猫耳萝莉
        NekoClothing nekoClothingLoli = new NekoClothing(alice);
        nekoClothingLoli.introduce();

        // 换装———泳装萝莉
        SwimClothing swimClothingLoli = new SwimClothing(alice);
        swimClothingLoli.introduce();
    }
}
