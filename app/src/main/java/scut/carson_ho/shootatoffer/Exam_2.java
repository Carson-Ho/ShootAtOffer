package scut.carson_ho.shootatoffer;

/**
 * Created by Carson_Ho on 17/12/4.
 */

public class Exam_2 {

    // 解法1：饿汉式
    // 缺点：在类初始化时，就创建了单例，并不是按需创建，存在资源浪费问题
    class Singleton1 {
        // 加载该类时，单例就会被实例化
        private static Singleton ourInstance  = new  Singleton();

        // 构造函数 = 私有权限
        // 原因：禁止他人创建实例
        private Singleton1() {
        }

        // 通过调用静态方法获得创建的单例
        public static  Singleton1 newInstance() {
            return ourInstance;
        }
    }


    // 解法2：懒汉式
    // 优点：解决了解法1的问题，按需创建
    // 缺点：非线程安全，不适合在多线程下使用，即，多个线程可能会并发调用 newInstance （），从而重复创建单例对象
    class Singleton2 {
        // 先赋值为Null，需要时才手动调用 newInstance（） 创建
        private static  Singleton ourInstance  = null；

        private Singleton2() {
        }

        // 创建单例
        public static  Singleton2 newInstance() {
            // 先判断单例是否为空，以避免重复创建
            if( ourInstance == null){
                ourInstance = new Singleton2();
            }
            return ourInstance;
        }
    }

    // 解法3：懒汉式变种：加入同步锁
    // 优点：解决了解法2的问题，即可在多线程使用
    // 原理：使用同步锁 synchronized (Singleton.class) ，防止多线程同时进入，从而造成instance被多次实例化
    // 缺点：效率低，原因：加锁 = 非常耗时操作，耗时耗能
    class Singleton3 {
        private static  Singleton ourInstance  = null；

        private Singleton3() {
        }

        public static  Singleton3 newInstance() {
            // 加入同步锁
            synchronized (Singleton3.class){
                if( ourInstance == null){
                    ourInstance = new Singleton3();
                }
            }
            return ourInstance;
        }
    }

    // 解法4：懒汉式变种：加入双重校验锁
    // 优点：解决了解法3的问题，即效率低的问题
    // 原理：在同步锁的基础上，添加1层 if判断：若Instance已实例化，则不必执行加锁操作就可以获取实例，从而提高性能
    // 缺点：实现复杂 = 多种判断，易出错
    class Singleton4 {
        private static  Singleton4 ourInstance  = null；

        private Singleton4() {
        }

        public static  Singleton4 newInstance() {
            // 在同步锁的基础上，添加1层if判断
            // 若单例已创建，则直接跳到执行 return ourInstance
            if( ourInstance == null){
                synchronized (Singleton4.class){
                    if( ourInstance == null){
                        ourInstance = new Singleton4();
                    }
                }
            }
            return ourInstance;
        }
    }

    // 解法5：静态内部类，即，在内部类里面去创建对象实例
    // 优点：更加优雅解决了上述问题：实现单例功能、按需加载，线程安全（多线程），效率高、实现简单
    class Singleton5 {

        // 在内部类里面去创建对象实例对象；在装载该内部类时才会去创建单例
        // 线程安全：类是由JVM加载的，而JVM只会加载一遍，保证只有1个单例模式，保证了数据同步
        private static class Singleton2{
            private static  Singleton5 ourInstance  = new Singleton5()；
        }

        // 私有构造函数
        private Singleton5() {
        }

        // 延迟加载、按需创建：外部调用类newInstance() ->调用Singleton2.ourInstance -> 创建实例
        public static  Singleton5 newInstance() {
            return Singleton5.ourInstance;
        }
    }

    // 解法6：枚举类型
    // 优点：更更更优雅解决了上述问题：实现单例功能、按需加载，线程安全（多线程），效率高、实现简单
    // 最简洁、易用的单例实现方式，（《Effective Java》推荐）
    public enum Singleton{

        //定义一个枚举的元素，它就是Singleton的一个实例
        instance;

        public void doSomething(){
        }

    }

    // 使用方式如下：

    Singleton singleton = Singleton.instance;
    singleton.doSomething();

}
