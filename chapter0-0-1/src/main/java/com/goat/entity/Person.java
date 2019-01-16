package com.goat.entity;

/**
 * Created by 64274 on 2018/9/10.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/9/10---17:16
 */
public class Person {

    private String name;
    private Integer age;

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "名字='" + name + '\'' +
                ", 年纪=" + age +
                '}';
    }
}