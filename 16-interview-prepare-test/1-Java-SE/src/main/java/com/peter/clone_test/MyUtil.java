package com.peter.clone_test;

import java.io.*;

/**
 * Copyright (C), Peter GUAN
 * FileName: MyUtil
 * Author:   Peter
 * Date:     27/04/2022 11:27
 * Description: 实现 Serializable 接口，通过对象的序列化和反序列化实现深度克隆
 * History:
 * Version:
 */
public class MyUtil {
    private MyUtil() {
        throw new AssertionError();
    }

    /**
     * 调用 ByteArrayInputStream 或 ByteArrayOutputStream 对象的 close 方法没有任何意义
     * 这两个基于内存的流只要垃圾回收器清理对象就能够释放资源，这一点不同于对外部资源（如文件流）的释放
     *
     * @param obj
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T extends Serializable> T clone(T obj) throws Exception {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bout);
        oos.writeObject(obj);

        ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bin);


        return (T) ois.readObject();
    }
}
