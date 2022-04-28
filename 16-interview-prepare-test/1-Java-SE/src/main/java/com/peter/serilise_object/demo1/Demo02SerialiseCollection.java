package com.peter.serilise_object.demo1;

import com.sun.corba.se.spi.ior.ObjectKey;

import java.io.*;
import java.util.ArrayList;

/**
 * Copyright (C), Peter GUAN
 * FileName: Demo02SerialiseCollection
 * Author:   Peter
 * Date:     28/04/2022 11:18
 * Description: 序列化集合对象
 * History:
 * Version:
 */
public class Demo02SerialiseCollection {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("tom1", 18, 98, 1));
        list.add(new Person("tom2", 19, 96, 2));
        list.add(new Person("tom3", 12, 97, 3));
        list.add(new Person("tom4", 11, 98, 4));

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("list.txt"));
        objectOutputStream.writeObject(list);

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("list.txt"));
        Object object = objectInputStream.readObject();

        ArrayList<Person> list1 = (ArrayList<Person>) object;
        for (Person person : list1) {
            System.out.println(person);
        }

        objectInputStream.close();
        objectOutputStream.close();
    }
}
