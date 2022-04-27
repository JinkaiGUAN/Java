package com.peter.pojo;

import java.io.Serializable;

/**
 * Copyright (C), Peter GUAN
 * FileName: Employee
 * Author:   Peter
 * Date:     26/04/2022 10:20
 * Description:
 * History:
 * Version:
 */


public class Employee implements Cloneable, Serializable {
    private static final long serialVersionUID = 1L;
    private String name;

    public Employee() {
        System.out.println("Employee Constructor Called...");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Employee other = (Employee) obj;
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Employee [name=" + name + "]";
    }

    @Override
    public Object clone() {
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return obj;
    }
}