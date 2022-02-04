package test;

import org.junit.Assert;
import sequenceList.LinkList;

/**
 * Copyright (C), Peter GUAN
 * FileName: LinkListTest
 * Author:   Peter
 * Date:     03/02/2022 22:16
 * Description:
 * History:
 * Version:
 */
public class LinkListTest {

    public static void main(String[] args) {
        LinkList<String> list = new LinkList<>();
        list.insert(0,"Tom_0");
        list.insert(1,"Tom_1");
        list.insert(2,"Tom_2");
        list.insert(3,"Tom_3");

        for (String s : list) {
            System.out.println(s);
        }

        System.out.println("------------");
        // length
        int listLength = list.length();
        Assert.assertEquals(4, listLength);

        // get
        Assert.assertEquals("Tom_2", list.get(2));

        // remove
        String removedName = list.remove(1);
        Assert.assertEquals("Tom_1", removedName);
        listLength = list.length();
        Assert.assertEquals(3, listLength);
        for (String s : list) {
            System.out.println(s);
        }

        // insert
        list.insert("Tom_4");
        list.insert(2, "Tom_5");
        Assert.assertEquals("Tom_5", list.get(2));
        System.out.println("------------");
        for (String s : list) {
            System.out.println(s);
        }

        int idx = list.indexOf("Tom_5");
        Assert.assertEquals(2, idx);
    }
}
