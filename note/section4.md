# 第4章 类和接口

## 第13条： 使类和成员的可访问性最小化

信息隐藏（information hiding）或封装（encapsulation）提高了软件的可重用性。

使用访问修饰符的第一规则：
**尽可能地使每个类或者成员不被无界访问。**

## 第14条：在公有类中使用访问方法而非公有域

退化类（degenerate classes）的实例：

    public class Point {
        public double x;
        public double y;
    }

这种方法暴露了数据域。
**如果类可以在它所在的包的外部进行访问，就提供访问方法。**

    public class Point {
        private double x;
        private double y;
    
        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    
        public double getX() { return x; }
    
        public void setX(double x) { this.x = x; }
    
        public double getY() { return y; }
    
        public void setY(double y) { this.y = y; }
    }

## 第15条： 使可变性最小化

不可变类比可变类更加易于设计、实现和使用。

使类成为不可变，要遵循5条原则：

**1、不要提供任何会修改对象状态的方法。**

**2、保证类不会被拓展。**
一般做法是使这个类成为final。另一种做法是让类的构造器变成私有，然后添加静态工厂（static factory）。

    public class Point {
        private double x;
        private double y;
    
        private Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    
        public static Point valueOf(double x, double y) {
            return new Point(x, y);
        }
    }

**3、使所有的域都是final的。**

**4、使所有域都成为私有的**
防止客户端直接修改对象。

**5、确保对于任何可变组件的互斥访问。**

不可变对象本质上是线程安全的，它们不需要同步。


## 第16条： 复合优先于继承

与方法调用不同的是，继承打破了封装性。

不用拓展现有的类，而是在新的类中增加一个私有域，它引用现有类的一个实例。这种设计被称做“复合”。

## 第17条： 要么为继承而设计，并提供文档说明，要么就禁止继承

## 第18条： 接口优于抽象类
