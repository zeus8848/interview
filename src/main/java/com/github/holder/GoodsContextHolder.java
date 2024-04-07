package com.github.holder;

import com.github.bo.Good;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author zeus
 * @date 2024/4/7
 * @description:
 */
public class GoodsContextHolder {
    private List<Good> shopingCart = new ArrayList<>();
    private BigDecimal totalPrice = BigDecimal.ZERO;

    public void addShopingCart(Good good){
        shopingCart.add(good);
    }
    public void addShopingCart(Good... goods){
        Collections.addAll(shopingCart, goods);
    }

    public List<Good> getShopingCart() {
        return shopingCart;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
