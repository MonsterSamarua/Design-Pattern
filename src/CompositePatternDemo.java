import java.util.ArrayList;
import java.util.List;

//// 树节点(统一接口)
interface TreeNode {
    void add(TreeNode node);
    void remove(TreeNode node);
    int countLadybird();
}

//// 树枝
class Branch implements TreeNode {

    // 树枝上可能有若干树枝和若干树叶，它们都是树节点
    private List<TreeNode> nodes = new ArrayList<>();

    @Override
    public void add(TreeNode node) {
        nodes.add(node);
    }

    @Override
    public void remove(TreeNode node) {
        nodes.remove(node);
    }

    // 组合模式和核心代码
    // 这是一个递归
    @Override
    public int countLadybird() {
        int count = 0;
        for (TreeNode node : nodes) {
            count += node.countLadybird();
        }
        return count;
    }
}

//// 树叶
class Leaf implements TreeNode {

    // 树叶上落的瓢虫数取随机数
    private int ladybirdNum = (int) (Math.random() * 10);

    @Override
    public void add(TreeNode node) { }

    @Override
    public void remove(TreeNode node) { }

    @Override
    public int countLadybird() {
        return ladybirdNum;
    }
}

public class CompositePatternDemo {
    public static void main(String[] args) {

        // 创造几个树枝
        Branch branch1 = new Branch();
        Branch branch2 = new Branch();
        // 创造几个树叶
        Leaf leaf1 = new Leaf();
        Leaf leaf2 = new Leaf();
        Leaf leaf3 = new Leaf();
        Leaf leaf4 = new Leaf();

        // 用树枝和树叶组合成一棵树
        branch1.add(branch2);
        branch1.add(leaf1);
        branch1.add(leaf2);
        branch2.add(leaf3);
        branch2.add(leaf4);

        // 这棵树上落了几只可爱的瓢虫呢？
        System.out.println(branch1.countLadybird());
    }
}
