package com.peter.serilise_object;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Copyright (C), Peter GUAN
 * FileName: SeriliseTest
 * Author:   Peter
 * Date:     28/04/2022 10:29
 * Description:
 * History:
 * Version:
 */
public class SerialiseTest {

    public static void main(String[] args) throws IOException {

        Student student = new Student();
        student.setName("Coder");
        student.setAge(18);
        student.setScore(100);

        // serialise the object
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(bout);
        objectOutputStream.writeObject(student);

        objectOutputStream.close();

        System.out.println("Serialise successfully!");



    }
}
