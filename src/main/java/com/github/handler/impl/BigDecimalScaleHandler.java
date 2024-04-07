package com.github.handler.impl;

import com.github.handler.GoodsPriceHandler;
import com.github.holder.GoodsContextHolder;
import org.springframework.core.annotation.Order;

import java.math.RoundingMode;

/**
 * @author zeus
 * @date 2024/4/7
 * @description: 四舍五入
 */
@Order()
public class BigDecimalScaleHandler implements GoodsPriceHandler {


    @Override
    public void handle(GoodsContextHolder holder) {
        holder.setTotalPrice(holder.getTotalPrice().setScale(2, RoundingMode.HALF_UP));
    }
}
