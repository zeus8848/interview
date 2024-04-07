package com.github.bo;

import com.github.enums.Goods;

import java.math.BigDecimal;

/**
 * @author zeus
 * @date 2024/4/7
 * @description: 芒果
 */
public class Mango extends Good {
    public Mango(int count) {
        super(Goods.Mango.name(), new BigDecimal("20"), count);
    }
}
