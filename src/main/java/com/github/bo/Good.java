package com.github.bo;

import java.math.BigDecimal;

/**
 * @author zeus
 * @date 2024/4/7
 * @description:
 */
public class Good {
    //商品名称
    private String name;
    //价格
    private BigDecimal price;
    //购买数量
    private int count;
    //库存
    private int inventory;
    //描述
    private String describe;

    public Good() {
    }

    public Good(String name, BigDecimal price, int count) {
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
