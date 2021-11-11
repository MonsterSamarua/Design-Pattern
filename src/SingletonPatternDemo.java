///**
// *【饿汉式】
// * 关键：饿汉很饿，在类加载时就实例化
// * 优点：没有加锁，所以效率更高
// * 缺点：类加载时就初始化，非Lazy-Loading，可能会产生大量用不到的垃圾对象
// * 补充：基于类加载机制，也解决了多线程问题
// */
//class Singleton {
//    private static Singleton instance = new Singleton();
//    private Singleton() {}
//    public static Singleton getInstance() {
//        return instance;
//    }
//}

///**
// *【懒汉式】
// * 关键：懒汉很懒，第一次调用时才初始化
// * 优点：第一次调用时才初始化，即Lazy-Loading，避免懒内存的浪费
// * 缺点：加synchronized同步锁才能保证单例，但加锁会影响效率
// * 补充：99%的情况用不到synchronized同步，所以加锁是个极大的浪费
// */
//class Singleton {
//    private static Singleton instance;
//    private Singleton() { }
//    public static synchronized Singleton getInstance() {
//        if (instance == null) {
//            instance = new Singleton();
//        }
//        return instance;
//    }
//}

///**
// *【双检锁】
// * 关键：采用双锁机制，在支持多线程的情况下保证性能
// * 补充：为什么要进行第二次判空？
// *      第一次判空时，可能有多个线程都判定instance为空，然后在锁外等待；
// *      之后它们进入锁后，不知道instance已经被刚刚进入的其他线程初始化过了，又会去重复初始化
// */
//class Singleton {
//    private static volatile Singleton instance;
//    private Singleton() {}
//    public static Singleton getInstance() {
//        if (instance == null) {
//            synchronized (Singleton.class) {
//                if (instance == null) {
//                    instance = new Singleton();
//                }
//            }
//        }
//        return instance;
//    }
//}

//class Singleton {
//    private static class SingletonHolder {
//        private static final Singleton INSTANCE = new Singleton();
//    }
//    private Singleton() {}
//    public static final Singleton getInstance() {
//        return SingletonHolder.INSTANCE;
//    }
//}

//enum Singleton {
//    INSTANCE;
//    public void doSomething() {
//        System.out.println("doSomething~");
//    }
//}


public class SingletonPatternDemo {
    public static void main(String[] args) throws Exception {

    }
}
