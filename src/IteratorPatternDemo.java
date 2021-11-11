//// 容器(接口)
interface Container {
    Iterator getIterator();
}

//// 迭代器(接口)
interface Iterator {
    boolean hasNext();
    Object next();
}

//// 微信
class WeChat implements Container {
    // 好友列表
    private String[] names = {"Mana", "Hana", "Alice", "Cocoa"};

    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }

    // 迭代器内部类
    private class NameIterator implements Iterator {
        private int index = 0;

        @Override
        public boolean hasNext() {
            if (index < names.length) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if (hasNext()) {
                return names[index++];
            }
            return null;
        }
    }
}

public class IteratorPatternDemo {
    public static void main(String[] args) {

        // 创建一个微信
        WeChat weChat = new WeChat();
        // 获取微信提供的迭代器
        Iterator wechatIterator = weChat.getIterator();

        // 使用迭代器
        while (wechatIterator.hasNext()) {
            System.out.println(wechatIterator.next());
        }
    }
}
