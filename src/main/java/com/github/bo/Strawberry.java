package com.github.bo;

import com.github.enums.Goods;

import java.math.BigDecimal;

/**
 * @author zeus
 * @date 2024/4/7
 * @description: 草莓
 */
public class Strawberry extends Good {
    public Strawberry(int count) {
        super(Goods.Strawberry.name(), new BigDecimal("13"), count);
    }
}
