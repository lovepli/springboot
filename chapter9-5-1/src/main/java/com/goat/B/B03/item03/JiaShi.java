package com.goat.B.B03.item03;

/**
 * Created by 64274 on 2018/6/26.
 * @author 山羊来了
 * @Description: 被代理 (委托类)
 * @date 2018/6/26---21:19
 */
public class JiaShi implements KindWomen {

    @Override
    public void makeEyesWithMan(){
        System.out.println("贾氏正在Happy中......");
    }

    @Override
    public void happyWithMan(){
        System.out.println("贾氏抛媚眼");
    }
}
