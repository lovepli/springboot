package com.goat.ch01_basic.object;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;
import org.junit.Test;

/**
     * @Description:  常用 Object 方法
     * @author: 杨帆
     * @Param:
     * @Return:
     * @Date:   2018/10/22
*/
public class ObjectExplained {

    public static void main(String args[]) {
        // toString
        new ObjectExplained().toStringHelperMethod();
        // 比较器 Comparator
        new ObjectExplained().compare();
    }

    /**
     * equals
     * 使用Objects.equal帮助执行null敏感的equals判断，从而避免抛出NullPointerException
     * 注意：JDK7引入的Objects类提供了一样的方法Objects.equals
     */
    @Test
    public void equalsMethod(){
        Objects.equal("a", "a"); // returns true
        Objects.equal(null, "a");  // returns false
        Objects.equal("a", null);  // returns false
        Objects.equal(null, null);  // returns true
    }

    /**
     * hashCode
     * 对传入的字段序列计算出合理的、顺序敏感的散列值
     * 可以使用Objects.hashCode(field1, field2, …, fieldn)来代替手动计算散列值
     * 注意：JDK7引入的Objects类提供了一样的方法Objects.hash(Object...)
     */
    @Test
    public void hashCodeMethod(){
        int hash = Objects.hashCode(2, "hello", null);
        System.out.println(hash);
    }

    /**
     * 轻松编写有用的toString方法
     */
    @Test
    public void toStringHelperMethod() {

        // Returns "ClassName{x=1}"
        String s1 = MoreObjects.toStringHelper(this)
                .add("x", 1)
                .toString();
        // ObjectExplained{x=1}
        System.out.println(s1);

        // Returns "MyObject{x=1}"
        String s2 = MoreObjects.toStringHelper("MyObject")
                .add("x", 1)
                .toString();
        // MyObject{x=1}
        System.out.println(s2);

    }

    /**
     * 比较器[Comparator]
     */
    @Test
    public void compare() {
        Person a = new Person("a", 10);
        Person b = new Person("a", 10);
        // Returns 1
        System.out.println(b.compareTo(a));
    }

    class Person implements Comparable<Person> {
        String name;
        int age;
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        /**
         * 执行比较操作直至发现非零的结果，在那之后的比较输入将被忽略
         * @param that
         * @return
         */
        public int compareTo(Person that) {
            return ComparisonChain.start()
                    .compare(this.age, that.age)
                    .compare(this.name, that.name)
                    .result();
        }
    }

}
