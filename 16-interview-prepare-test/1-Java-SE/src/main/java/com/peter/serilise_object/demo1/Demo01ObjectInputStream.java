package com.peter.serilise_object.demo1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Copyright (C), Peter GUAN
 * FileName: Demo01ObjectInputStream
 * Author:   Peter
 * Date:     28/04/2022 10:51
 * Description:
 * History:
 * Version:
 */
public class Demo01ObjectInputStream {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("person.txt"));
        Object object = objectInputStream.readObject();
        System.out.println(object);
        objectInputStream.close();

        Person person = (Person)object;
        System.out.println(person);
    }
}
