//// 圆孔
class RoundHole {
    private double radius;

    public RoundHole(double radius) {
        this.radius = radius;
    }

    public boolean fits(RoundPeg roundPeg) {
        return radius >= roundPeg.getRadius();
    }
}

//// 圆钉
class RoundPeg {
    private double radius;

    public RoundPeg() { }
    public RoundPeg(double radius) { this.radius = radius; }

    public double getRadius() {
        return radius;
    }
}

//// 方钉
class SquarePeg {
    private double width;

    public SquarePeg() { }
    public SquarePeg(double width) { this.width = width; }

    public double getWidth() {
        return width;
    }
}


//// 适配器(方钉->圆钉)
class Adapter extends RoundPeg {

    private SquarePeg squarePeg;

    public Adapter(SquarePeg squarePeg) {
        this.squarePeg = squarePeg;
    }

    @Override
    public double getRadius() {
        return Math.sqrt(Math.pow((squarePeg.getWidth() / 2), 2) * 2);
    }
}

public class AdapterPatternDemo {
    public static void main(String[] args) {

        // 生成一个圆孔
        RoundHole roundHole = new RoundHole(5);

        // 生成俩个方钉
        SquarePeg squarePeg1 = new SquarePeg(4);
        SquarePeg squarePeg2 = new SquarePeg(8);

        // 使用适配器(圆钉的外表，方钉的内容)
        Adapter adapter1 = new Adapter(squarePeg1);
        Adapter adapter2 = new Adapter(squarePeg2);

        // 方钉匹配圆孔
        System.out.println(roundHole.fits(adapter1) ? "fits" : "not fits");
        System.out.println(roundHole.fits(adapter2) ? "fits" : "not fits");
    }
}
