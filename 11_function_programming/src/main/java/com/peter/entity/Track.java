package main.java.com.peter.entity;

/**
 * Copyright (C), Peter GUAN
 * FileName: Track
 * Author:   Peter
 * Date:     08/04/2022 20:24
 * Description:
 * History:
 * Version:
 * @author Peter
 */
public class Track {
    private String name;
    private int length;

    public Track(String name, int length) {
        this.name = name;
        this.length = length;
    }

    public Track copy() {
        return new Track(name, length);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Track{" +
                "name='" + name + '\'' +
                ", length=" + length +
                '}';
    }
}
