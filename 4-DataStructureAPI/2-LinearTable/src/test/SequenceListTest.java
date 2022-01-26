package test;


import sequenceList.SequenceList;

/**
 * Copyright (C), Peter GUAN
 * FileName: SequenceListTest
 * Author:   Peter
 * Date:     26/01/2022 09:36
 * Description:
 * History:
 * Version:
 */
public class SequenceListTest {
    public static void main(String[] args) throws Exception {

        SequenceList<String> squence = new SequenceList<>(5);
//测试遍历
        squence.insert(0, "姚明");
        squence.insert(1, "科比");
        squence.insert(2, "麦迪");
        squence.insert(3, "艾佛森");
        squence.insert(4, "卡特");
        for (String s : squence) {
            System.out.println(s);
        }
    }

}
