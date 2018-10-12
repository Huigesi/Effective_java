

# 第7章 方法

## 第38条: 检查参数的有效性

非公有的方法通常应该使用断言检查它们的参数。

        private static void sort(long a[], int offset, int length) {
            assert a != null;
            assert offset >=0&& offset<=a.length;
            assert length >= 0 && length <= a.length - offset;
        }

断言失败将会抛出AssertionError。

## 第39条： 必要时进行保护性拷贝

保护性拷贝（defensive copy）：
    
    public Period(Date start, Date end) {
            /*if (start.compareTo(end) > 0) {
                throw new IllegalArgumentException(start + "after" + end);
            }
            this.start=start;
            this.end=end;*/
            //Date本身可变，所以上诉写法很容易违反约束条件。
            this.start = new Date(start.getTime());
            this.end = new Date(end.getTime());
            if (this.start.compareTo(this.end) > 0) {
                throw new IllegalArgumentException(start + "after" + end);
            }
        }

**保护性拷贝是在检查参数的有效性之前进行的，并且有效性检查是针对拷贝之后的对象。**

## 第40条： 谨慎设计方法签名

**谨慎选择方法的名称**
遵循标准的命名习惯（第56条）

**不要过于追求提供便利的方法**
一项操作经常用到时才考虑为它提供快捷方式。

**避免过长的参数列表**

缩短参数列表的方法：
1、把方法分解成多个方法。
2、创建辅助类。
3、从对象构建到方法调用都采用Builder模式。

## 第41条： 慎用重载

不要导出两个具有相同参数数目的重载方法。

Java出了自动装箱和泛型后，重载的使用就需要更加谨慎了。
例子：

    public class SetList {
        public static void main(String[] args) {
            Set<Integer> set = new TreeSet<>();
            List<Integer> list = new ArrayList<>();
            for (int i = -3; i < 3; i++) {
                set.add(i);
                list.add(i);
            }
            for (int i = 0; i < 3; i++) {
                set.remove(i);
                //这里i被自动装箱到Integer中。程序不会从集合中去除正值
                //列表去除的是从哪个位置开始
                //list.remove( i);
                list.remove((Integer)i);
            }
            System.out.println(set + " " + list);
        }
    }
## 第42条： 慎用可变参数

在重视性能的情况下，声明该方法的5个重载。当参数的数目超过3个时，就使用一个可变参数方法。

    public Foo() {}
    public Foo(int a1) {}
    public Foo(int a1, int a2) {}
    public Foo(int a1, int a2, int a3) {}
    public Foo(int a1, int a2, int a3, int... rest) {}


## 第43条: 返回零长度的数组或集合，而不是null

## 第44条： 为所有导出的API元素编写文档注释

  
    
