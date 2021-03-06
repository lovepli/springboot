package com.goat.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component // 放入spring容器
@PropertySource("classpath:blogproperties.properties")
public class BlogProperties {

    @Value("${com.didispace.blog.name}")
    private String name;
    @Value("${com.didispace.blog.title}")
    private String title;
    @Value("${com.didispace.blog.desc}")
    private String desc;
    @Value("${com.didispace.blog.value}")
    private String value;
    @Value("${com.didispace.blog.number}")
    private Integer number;
    @Value("${com.didispace.blog.bignumber}")
    private Long bignumber;
    @Value("${com.didispace.blog.test1}")
    private Integer test1;
    @Value("${com.didispace.blog.test2}")
    private Integer test2;

    @Value("#{11*2}") //  可以通过表达式 计算
    private Integer test3;


    @Override
    public String toString() {
        return "BlogProperties{" + "name='" + name + '\'' + ", title='" + title + '\'' + ", desc='" + desc + '\'' + ", value='" + value + '\'' + ", number=" + number + ", bignumber=" + bignumber + ", test1=" + test1 + ", test2=" + test2 + ", test3=" + test3 + '}';
    }

    public Integer getTest3() {
        return test3;
    }

    public void setTest3(Integer test3) {
        this.test3 = test3;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Long getBignumber() {
        return bignumber;
    }

    public void setBignumber(Long bignumber) {
        this.bignumber = bignumber;
    }

    public Integer getTest1() {
        return test1;
    }

    public void setTest1(Integer test1) {
        this.test1 = test1;
    }

    public Integer getTest2() {
        return test2;
    }

    public void setTest2(Integer test2) {
        this.test2 = test2;
    }
}
