package com.github.handler;


import com.github.holder.GoodsContextHolder;

import java.math.BigDecimal;

/**
 * @author zeus
 * @date 2024/4/7
 * @description:
 */
public interface GoodsPriceHandler {
    void handle(GoodsContextHolder contextHolder);
}
