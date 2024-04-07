package com.github.handler.impl;

import com.github.bo.Good;
import com.github.handler.GoodsPriceHandler;
import com.github.holder.GoodsContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 * @author zeus
 * @date 2024/4/7
 * @description: 正常价格计算
 */
@Order(100)
public class NormalPriceHandler implements GoodsPriceHandler {

    @Override
    public void handle(GoodsContextHolder holder) {
        List<Good> shopingCart = holder.getShopingCart();
        BigDecimal totalPrice = holder.getTotalPrice();
        for (Good good : shopingCart) {
            BigDecimal price =  good.getPrice().multiply(new BigDecimal(good.getCount()));
            totalPrice =  totalPrice.add(price);
        }
        holder.setTotalPrice(totalPrice);
    }
}
