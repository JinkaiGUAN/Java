package com.peter.clone_test;

/**
 * Copyright (C), Peter GUAN
 * FileName: CloneTest
 * Author:   Peter
 * Date:     27/04/2022 11:37
 * Description:
 * History:
 * Version:
 */
public class CloneTest {
    public static void main(String[] args) {
        try {
            Person p1 = new Person("Hao LUO", 33, new Car("Benz", 300));
            Person p2 = MyUtil.clone(p1);
            p2.getCar().setBrand("BYD");
            // 修改克隆的 Person 对象 p2 关联的汽车对象的品牌属性
            // 原来的 Person 对象 p1 关联的汽车不会受到任何影响
            // 因为在克隆 Person 对象时其关联的汽车对象也被克隆了
            System.out.println(p1);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
