package com.github.handler.impl;


import com.github.bo.Good;
import com.github.enums.Goods;
import com.github.handler.GoodsPriceHandler;
import com.github.holder.GoodsContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Iterator;
import java.util.List;

/**
 * @author zeus
 * @date 2024/4/7
 * @description: 草莓促销 打8折
 */
@Order(10)
public class StrawBerryPriceHandler implements GoodsPriceHandler {

    @Override
    public void handle(GoodsContextHolder holder) {
        List<Good> shopingCart = holder.getShopingCart();
        Iterator<Good> iterator = shopingCart.iterator();
        while (iterator.hasNext()){
            Good good = iterator.next();
            if (Goods.Strawberry.name().equals(good.getName())){
                BigDecimal price =  good.getPrice().multiply(new BigDecimal(good.getCount()));
                price = price.multiply(new BigDecimal(0.8));
                holder.setTotalPrice(holder.getTotalPrice().add(price));
                iterator.remove();
            }
        }
    }
}
