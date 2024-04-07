package com.github.handler.impl;

import com.github.handler.GoodsPriceHandler;
import com.github.holder.GoodsContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;

import java.math.BigDecimal;

/**
 * @author zeus
 * @date 2024/4/7
 * @description: 满减折扣
 */
@Order(200)
public class FullDiscountHandler implements GoodsPriceHandler {

    @Override
    public void handle(GoodsContextHolder holder) {
        BigDecimal totalPrice = holder.getTotalPrice();
        //满100减10
        if (totalPrice.compareTo(new BigDecimal("100"))>0){
            BigDecimal price = totalPrice.subtract(new BigDecimal("10"));
            holder.setTotalPrice(price);
        }

    }
}
