# 第3章 对于所有对象都通用的方法
 主要讲述非final方法(equals、hashCode、toString、clone和finalize)被覆盖时要遵守的通用约定。

## 第8条: 覆盖equals时请遵守通用约定

满足什么条件可以不用去覆盖equals方法？

**·类的每个实例本质上都是唯一的。**

例如Thread。

**·不关心类是否提供了“逻辑相等(logical equality)”的测试功能**

例如java.util.Random

**·超类已经覆盖了equals,从超类继承过来的行为对于子类也是合适的。**

例如Set实现从AbstractSet继承equals实现。


在“值类”(Integer或者Date)中需要对equals方法进行覆盖。有一种“值类”不需要覆盖，比如枚举类型。


覆盖equals方法的时候要遵循的通用约定：

**·自反性**

对于任何非null的引用值x，x.equals(x)必须返回true。其实就是要求对象必须等于自身。

**·对称性**

x.equals(y)为true,则y.equals(x)为true。

**·传递性**

x.equals(y)为true，y.equals(z)为true，则x.equals(z)为true。

**·一致性**

只要对象信息没有被修改，多次调用后依然为true。

**·非空性**

所有对象都必须不等于null。


## 第9条：覆盖equals时总要覆盖hashCode

应用程序执行期间，只要对象的信息没有被修改，那么对这同一对象调用多次，hashCode方法都必须
始终如一地返回同一个整数。

如果两个对象根据equals方法比较时相等的，那么调用其中一个对象的hasCode方法都必须产生同样的整数结果。

## 第10条： 始终要覆盖toString

实际应用中，toString方法应该返回对象中包含的所有值得关注的信息。

## 第11条: 谨慎地覆盖clone

如果覆盖了非final类中的clone方法，则应该返回一个通过调用super.clone而得到的对象。

## 第12条: 考虑实现Comparable接口

