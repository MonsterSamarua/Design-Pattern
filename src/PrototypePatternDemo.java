//import java.util.HashMap;
//import java.util.Map;
//
////// 动物抽象类(这个父类中拥有clone方法)
//abstract class Animal implements Cloneable {
//
//    public String type;
//
//    public String getType() {
//        return type;
//    }
//
//    public Object clone() throws CloneNotSupportedException {
//        return super.clone();
//    }
//}
//
////// 考拉
//class Koala extends Animal { public Koala() { type = "Koala"; }}
////// 熊猫
//class Panda extends Animal { public Panda() { type = "Panda"; }}
////// 鲨鱼
//class Shark extends Animal { public Shark() { type = "Shark"; }}
//
//
////// 原型注册表(核心逻辑)
//class AnimalCache {
//
//    private static Map<String, Animal> animalMap = new HashMap<>();
//
//    public static Animal getAnimal(String typeId) throws CloneNotSupportedException {
//        Animal cacheAnimal = animalMap.get(typeId);
//        return (Animal) cacheAnimal.clone();
//    }
//
//    public static void initCache() {
//        animalMap.put("1", new Koala());
//        animalMap.put("2", new Panda());
//        animalMap.put("3", new Shark());
//    }
//
//}
//
//public class PrototypePatternDemo {
//    public static void main(String[] args) throws CloneNotSupportedException {
//
//        // 初始化原型注册表
//        AnimalCache.initCache();
//
//        // 拷贝出一只考拉
//        Animal koala = AnimalCache.getAnimal("1");
//        System.out.println(koala.getType());
//
//        // 拷贝出一只熊猫
//        Animal panda = AnimalCache.getAnimal("2");
//        System.out.println(panda.getType());
//
//        // 拷贝出一只鲨鱼
//        Animal shark = AnimalCache.getAnimal("3");
//        System.out.println(shark.getType());
//
//    }
//}