>个人读书笔记，部分没读懂的知识点简洁概括或缺失，以后反复阅读后再完善。

#第二章 创建和摧毁对象

####第1条:使用静态工厂方法替代构造器
静态工厂方法的好处。

1、有命名，更方便阅读。
2、不用每次调用都创建新对象（构造器需要）。
3、可以返回原返回类型的任何子类型对象（更灵活）。
4、创建参数化类型实例使代码更简洁。
例子：

    public static <K, V> HashMap<K, V> newInstance() {
            return new HashMap<>();
    }
        
    Map<String, List<String>> m =Singleton.newInstance();

静态工厂方法的坏处。

1、类如果不含有公有或者受保护的构造器，就不能被子类化。
2、与静态方法没有区别（不方便阅读？）

####第2条:遇到多个构造器时要考虑用构建器
类中有多个参数，一般使用的重叠构造器（telescoping constructor）模式有不好的地方，比如有些不想设置的参数也不得不传值。

解决办法提到了javaBeans模式与Builder模式。

javaBeans模式:

    public class NutritionFacts {
        private int servingSize = -1;
        private int servings = -1;
        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;
    
        public NutritionFacts() {
        }
    
        public void setServingSize(int servingSize) {
            this.servingSize = servingSize;
        }
    
        public void setServings(int servings) {
            this.servings = servings;
        }
    
        public void setCalories(int calories) {
            this.calories = calories;
        }
    
        public void setFat(int fat) {
            this.fat = fat;
        }
    
        public void setSodium(int sodium) {
            this.sodium = sodium;
        }
    
        public void setCarbohydrate(int carbohydrate) {
            this.carbohydrate = carbohydrate;
        }
    }
Builder模式：

    public class NutritionFacts {
       
        private int servingSize;
        private int servings;
        private int calories;
        private int fat;
        private int sodium;
        private int carbohydrate;
    
        public static class Builder {
            private final int servingSize;
            private final int servings;
    
            private int calories = 0;
            private int fat = 0;
            private int sodium = 0;
            private int carbohydrate = 0;
    
            public Builder(int servingSize, int servings) {
                this.servingSize = servingSize;
                this.servings = servings;
            }
    
            public Builder setCalories(int calories) {
                this.calories = calories;
                return this;
            }
    
            public Builder setFat(int fat) {
                this.fat = fat;
                return this;
            }
    
            public Builder setSodium(int sodium) {
                this.sodium = sodium;
                return this;
            }
    
            public Builder setCarbohydrate(int carbohydrate) {
                this.carbohydrate = carbohydrate;
                return this;
            }
        }
    
        private NutritionFacts(Builder builder) {
            servingSize=builder.servingSize;
            servings=builder.servings;
            calories=builder.calories;
            fat=builder.fat;
            sodium=builder.sodium;
            carbohydrate=builder.carbohydrate;
        }
    }
Builder模式调用代码：

    NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8)
                        .setCalories(100)
                        .setSodium(35)
                        .setCarbohydrate(27)
                        .build();

如果类的构造器或者静态工厂中具有多个参数，推荐Builder模式。

####第3条：用私有构造器或者枚举类型强化Singleton属性

**Singleton**指仅仅被实例化一次的类。

java 1.5以前，实现Singleton的两种方法：

    public class Elvis {
        private static final Elvis INSTANCE = new Elvis();
    
        private Elvis() {}
        
        private static Elvis getInstance(){
            return INSTANCE;
        }
    
        public void leaveTheBuilding() {}
    }

或：

    public class Elvis2 {
        private static Elvis2 ourInstance = new Elvis2();
    
        public static Elvis2 getInstance() {
            return ourInstance;
        }
    
        private Elvis2() {
        }
        public void leaveTheBuilding() {}
    }
第二个方法（工厂方法）更灵活。使用泛型更优（第27条）
java 1.5之后实现Singleton的第三种方法：

    public enum Elvis3 {
        INSTANCE;
        public void leaveTheBuilding() {}
    }

####第4条：通过私有构造器强化不可实例化的能力

有些工具类不希望被实例化，企图通过将类做成抽象类来强制该类不可被实例化是行不通的。

可以让这个类包含有私有构造器：

    public class UtilityClass {
        private UtilityClass() {
            throw new AssertionError();
        }
    }
该做法的副作用：使得一个类不能被子类化。

####第5条：避免创建不必要的对象

**最好能重用对象，而不是每次需要的时候创建一个相同功能的新对象。**
极端例子：

    String s = new String("stringette");
如果上面这种写法用在循环中，会创建成千上万不必要的String实例。
正常写法：

    String s = "stringette";

有些**已知不会被修改的可变对象**，也可以重用。
重用前例子：

    class Person{
        private final Date birthDate;
    
        public Person(Date birthDate) {
            this.birthDate = birthDate;
        }
    
        /*
         * 效率低下的方法
         * */
        public boolean isBabyBoomer() {
            Calendar gmtCal=Calendar.getInstance(TimeZone.getTimeZone("GMT"));
            gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
            Date boomStart=gmtCal.getTime();
            gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
            Date boomEnd=gmtCal.getTime();
            return birthDate.compareTo(boomStart) >= 0 &&
                    birthDate.compareTo(boomEnd) < 0;
        }
    }
重用后例子（调用速度明显增快）：

    class Person{
        private final Date birthDate;
    
        public Person(Date birthDate) {
            this.birthDate = birthDate;
        }
        /*
         *改进后的做法(快了250倍)
         * */
        private static final Date BOOM_START;
        private static final Date BOOM_END;
        static {
            Calendar gmtCal=Calendar.getInstance(TimeZone.getTimeZone("GMT"));
            gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
            BOOM_START=gmtCal.getTime();
            gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
            BOOM_END=gmtCal.getTime();
        }
    
        public boolean isBabyBoomer2() {
            return birthDate.compareTo(BOOM_START) >= 0 &&
                    birthDate.compareTo(BOOM_END) < 0;
        }
    }    


**要优先使用基本类型而不是装箱基本类型，要当心无意识的自动装箱。**

例子：

    public static void main(String[] args) {
            Long sum=0L;
            for (long i = 0; i < Integer.MAX_VALUE; i++) {
                sum += i;
            }
            System.out.println(sum);
        }
        
sum的声明是Long而不是long,意味着程序构造了许多的多余的Long实例。运行时间大大降低。

####第6条：消除过期对象的应用

一个存在内存泄露的程序：

    public class Stack {
        private Object[] elements;
        private int size = 0;
        private static final int DEFAULT_INITIAL_CAPACITY = 16;
    
        public Stack() {
            elements = new Object[DEFAULT_INITIAL_CAPACITY];
        }
    
        public void push(Object e) {
            ensureCapacity();
            elements[size++] = e;
        }
    
        public Object pop() {
            if (size == 0) {
                throw new EmptyStackException();
            }
            //这样写会有内存泄漏
            return elements[--size];
            /*
            * 清空过期的引用
            * */
            //Object result = elements[--size];
            //elements[size]=null;
            //return result;
        }
    
        private void ensureCapacity() {
            if (elements.length == size) {
                elements = Arrays.copyOf(elements, 2 * size + 1);
            }
        }
    }

代码中通过清空过期应用解决内存泄漏：

    Object result = elements[--size];
        elements[size]=null;
        return result;
####第7条：避免使用过期方法

讲终结方法（finalizer）通常不可预测，一般情况下是不必要的。
使用终结方法还会有性能损失。

