//// 策略(接口)
interface Strategy {
    int doOperation(int num1, int num2);
}

//// 加法策略
class OperationAdd implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}

//// 减法策略
class OperationSub implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}

//// 乘法策略
class OperationMul implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}

//// 除法策略
class OperationDiv implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 / num2;
    }
}


//// 计算器
class Calculator {
    // 拥有一个策略对象成员变量
    private Strategy strategy;

    // 设置策略
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    // 执行策略
    public int executeStrategy(int num1, int num2) {
        return strategy.doOperation(num1, num2);
    }
}

public class StrategyPatternDemo {
    public static void main(String[] args) {

        // 获取计算器
        Calculator calculator = new Calculator();

        // 设置加法策略并执行
        calculator.setStrategy(new OperationAdd());
        System.out.println(calculator.executeStrategy(12, 4));

        // 设置减法策略并执行
        calculator.setStrategy(new OperationSub());
        System.out.println(calculator.executeStrategy(12, 4));

        // 设置乘法策略并执行
        calculator.setStrategy(new OperationMul());
        System.out.println(calculator.executeStrategy(12, 4));

        // 设置除法策略并执行
        calculator.setStrategy(new OperationDiv());
        System.out.println(calculator.executeStrategy(12, 4));
    }
}
