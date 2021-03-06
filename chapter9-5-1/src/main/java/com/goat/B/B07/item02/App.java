package com.goat.B.B07.item02;


import org.junit.Test;

/**
     * @Description: 功能描述：(这里用一句话描述这个方法的作用)
     * @author: 杨帆
     * @Param: 
     * @Return: 
     * @Date:   2019/10/15
*/
public class App {

    private static FlyweightFactory factory = new FlyweightFactory();
    private static FlyweightFactorySingleton instance = FlyweightFactorySingleton.getInstance();

    @Test
    public void test0(){
        test(factory);
    }

    @Test
    public void test1(){
        test(instance);
    }


    public static void test(Factory factory) {

        Flyweight fly = factory.factory('a');
        fly.operation("First Call");

        fly = factory.factory('b');
        fly.operation("Second Call");

        fly = factory.factory('a');
        fly.operation("Third Call");

        fly = factory.factory('e');
        fly.operation("Third Call");

        // intrinsic Flyweight
        factory.checkFlyweight();
    }
}
