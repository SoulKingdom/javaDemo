package com.example.junittest.design.mode.prototype;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 *  @dept 上海软件研发中心
 *  @description TODO
 *  @author HaoXin.Liu
 *  @date 2019/9/5 19:08
 **/
@Data
public class Person implements Cloneable {
    private String name;
    private String sex;
    private List<String> list;

    @Override
    public Person clone() {
        try {
            Person person = (Person) super.clone();
            List<String> listTo = new ArrayList<>(0);
            for (String str : this.list) {
                listTo.add(str);
            }
            person.setList(listTo);
            return person;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}