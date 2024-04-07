package com.github.bo;

import com.github.enums.Goods;

import java.math.BigDecimal;

/**
 * @author zeus
 * @date 2024/4/7
 * @description: 苹果
 */
public class Apple extends Good {
    public Apple(int count) {
        super(Goods.Apple.name(),new BigDecimal("8"),count);
    }
}
