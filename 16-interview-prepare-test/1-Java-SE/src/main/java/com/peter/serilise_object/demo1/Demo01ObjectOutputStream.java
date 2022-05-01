package com.peter.serilise_object.demo1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Copyright (C), Peter GUAN
 * FileName: Demo01ObjectOutputStream
 * Author:   Peter
 * Date:     28/04/2022 10:44
 * Description:
 * History:
 * Version:
 */
public class Demo01ObjectOutputStream {

    /**
     * 创建步骤
     * 1. 创建 ObjectOutputStream 对象， 并指定输出对象(字节输入流)。
     * 2. 使用 writeObject 方法写入对象
     * 3. 释放资源
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.txt"));
        oos.writeObject(new Person("Tome", 12, 98, 1));
        oos.close();
    }
}
