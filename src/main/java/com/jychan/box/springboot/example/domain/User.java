package com.jychan.box.springboot.example.domain;

/**
 * @author Raymond
 * @version 15/12/7 12:55
 * @E-mail:415683089@qq.com
 */
public class User {

    private int id;
    private String name;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();
        buf.append("{");
        buf.append(id);
        buf.append(",");
        buf.append(name);
        buf.append(",");
        buf.append(age);
        buf.append("}");
        return buf.toString();
    }
}
