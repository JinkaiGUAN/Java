package spring01.entity;

/**
 * Copyright (C), Peter GUAN
 * FileName: Page
 * Author:   Peter
 * Date:     09/03/2022 13:57
 * Description: 用来封装分页相关的信息
 * History:
 * Version:
 */
public class Page {

    private int current = 1; // 当前页码
    private int limit = 10; // 每个页面能呈现的数据量
    private int rows; // 数据总数 用于计算总页数
    private String path; // 查询路径， 复用分页链接

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        if (current >= 1) {
            this.current = current;
        }
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        if (limit >= 1 && limit <= 100) {
            this.limit = limit;
        }
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        if (rows > 0) {
            this.rows = rows;
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 获取当前页的起始行
     * @return
     */
    public int getOffset(){
        return (current - 1) * limit;
    }

    /**
     * 获取总页数
     * @return
     */
    public int getTotal() {
        if (rows % limit == 0) {
            return rows / limit;
        } else {
            return rows / limit + 1;
        }
    }

    /**
     * 获取起始页码
     * @return
     */
    public int getFrom() {
        int from = current - 2;

        return from < 1 ? 1 : from;
    }

    /**
     * 获取结束页码
     * @return
     */
    public int getTo() {
        int to = current + 2;

        return to > getTotal() ? getTotal() : to;
    }
}
