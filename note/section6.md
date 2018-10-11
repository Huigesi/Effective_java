
# 第6章 枚举和注解

## 第30条：用enum代替int常量

int枚举模式：

    public static final int APPLE_FUJI=0;
    public static final int APPLE_PIPPIN=1;
    public static final int APPLE_GRANNY_SMITH=2;

int枚举模式如果与枚举常量关联的int发生了变化，客户端就必须重新编译。

枚举类型：

    public enum Apple{FUJI,PIPPIN,GRANNY_SMITH}

## 第31条： 用实例域代替序数

ordinal方法返回每个枚举常量在类型中的数字位置。

        public enum Ensemble{
            SOLO,DUET,TRIO,QUARTET,QUINTET,
            SEXTET,SEPTET,OCTET,NONET,DECTET;
    
            public int numberOfMusicians() { return ordinal()+1; }
        }
但最好用这种写法：

        public enum Ensemble{
            SOLO(1),DUET(2),TRIO(3),QUARTET(4),QUINTET(5),
            SEXTET(6),SEPTET(7),OCTET(8),NONET(9),DECTET(10),
            TRIPLE_QUARTET(12);
            private final int numberOfMusicians;
    
            Ensemble(int size) {
                this.numberOfMusicians = size;
            }
            public int numberOfMusicians() { return numberOfMusicians; }
        }
        
## 第31条： 用EnumSet代替位域

int枚举模式：

    public class Text {
        public static final int STYLE_BOLD=1<<0;
        public static final int STYLE_ITALIC=1<<1;
        public static final int STYLE_UNDERLINE=1<<2;
        public static final int STYLE_STRIKETHROUGH=1<<3;
    
        public void applyStyles(int styles) {
            
        }
    }
这种表示法让你用OR运算符将几个常量合并到一个集合中，称作**位域**：

    text.applyStyles(STYLE_BOLD|STYLE_ITALIC);

用枚举代替位域后的代码:

    public class Text {
        public enum Style{BOLD,ITALIC,UNDERLINE,STRIKETHROUGH}
    
        public void applyStyles(Set<Style> styles) {
    
        }
    }

客户端代码：

    text.applyStyles(EnumSet.of(Text.Style.BOLD, Text.Style.UNDERLINE));

正是因为枚举类型要用在集合中，所以没有理由用位域来表示它。

## 第33条： 用EnumMap代替序数索引

## 第34条： 用接口模拟可伸缩的枚举

虽然无法编写可扩展的枚举类型，却可以通过编写接口以及实现接口的基础枚举类型。

## 第35条： 注解优于命名模式

## 第36条： 坚持使用Override注解

## 第37条： 用标记接口定义类型

