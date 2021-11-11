import java.util.ArrayList;
import java.util.List;

//// 单品接口
interface Item {
    String getName();
    int getPrice();
}

//// 蛋糕类
class Cake implements Item {

    @Override
    public String getName() {
        return "我是一块蛋糕";
    }

    @Override
    public int getPrice() {
        return 12;
    }
}

//// 牛肉类
class Beef implements Item {

    @Override
    public String getName() {
        return "我是一份牛肉";
    }

    @Override
    public int getPrice() {
        return 80;
    }
}

//// 咖啡类
class Coffee implements Item {

    @Override
    public String getName() {
        return "我是一杯咖啡";
    }

    @Override
    public int getPrice() {
        return 30;
    }
}

//// 红酒类
class RedWine implements Item {

    @Override
    public String getName() {
        return "我是一瓶红酒";
    }

    @Override
    public int getPrice() {
        return 400;
    }
}

//// 一顿正餐
//// 通常是单品组合成的套餐
class Meal {

    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public void showItems() {
        for (Item item : items) {
            System.out.println(item.getName());
        }
    }

    public void showTotalPrice() {
        int total = 0;
        for (Item item : items) {
            total += item.getPrice();
        }
        System.out.println(total);
    }
}

//// 套餐建造器
class MealBuilder {

    public Meal prepareMeal1() {
        Meal meal = new Meal();
        meal.addItem(new Cake());
        meal.addItem(new Coffee());
        return meal;
    }

    public  Meal prepareMeal2() {
        Meal meal = new Meal();
        meal.addItem(new Beef());
        meal.addItem(new RedWine());
        return meal;
    }
}


public class BuilderPatternDemo {
    public static void main(String[] args) {

        // 新建一个正餐建造器
        MealBuilder mealBuilder = new MealBuilder();

        // 构造套餐1
        Meal meal1 = mealBuilder.prepareMeal1();
        // 展示一下套餐
        meal1.showItems();
        meal1.showTotalPrice();

        // 构造套餐2
        Meal meal2 = mealBuilder.prepareMeal2();
        // 展示一下套餐
        meal2.showItems();
        meal2.showTotalPrice();
    }
}
