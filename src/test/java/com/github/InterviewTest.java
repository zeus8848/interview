package com.github;

import com.github.bo.Apple;
import com.github.bo.Mango;
import com.github.bo.Strawberry;
import com.github.handler.HandlerChain;
import com.github.handler.impl.FullDiscountHandler;
import com.github.handler.impl.NormalPriceHandler;
import com.github.handler.impl.StrawBerryPriceHandler;
import com.github.holder.GoodsContextHolder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

/**
 * @author zeus
 * @date 2024/4/7
 * @description:
 */
@SpringBootTest
public class InterviewTest {

    @Test
    @DisplayName("问题一")
    public void questionOneTest() {
        Apple apple = new Apple(2);
        Strawberry strawberry = new Strawberry(1);
        GoodsContextHolder goodsContextHolder = new GoodsContextHolder();
        goodsContextHolder.addShopingCart(apple, strawberry);
        HandlerChain handlerChain = new HandlerChain();
        handlerChain.handle(goodsContextHolder);
        Assertions.assertEquals(goodsContextHolder.getTotalPrice(),new BigDecimal("29.00"));
    }

    @Test
    @DisplayName("问题二")
    public void questionTwoTest() {
        Apple apple = new Apple(2);
        Strawberry strawberry = new Strawberry(1);
        Mango mango = new Mango(1);
        GoodsContextHolder goodsContextHolder = new GoodsContextHolder();
        goodsContextHolder.addShopingCart(apple, strawberry,mango);
        HandlerChain handlerChain = new HandlerChain();
        handlerChain.handle(goodsContextHolder);
        Assertions.assertEquals(goodsContextHolder.getTotalPrice(),new BigDecimal("49.00"));
    }

    @Test
    @DisplayName("问题三")
    public void questionThreeTest() {
        GoodsContextHolder goodsContextHolder = new GoodsContextHolder();
        goodsContextHolder.addShopingCart(new Apple(2), new Strawberry(1),new Mango(1));
        HandlerChain handlerChain = new HandlerChain();
        handlerChain.addHandler(new StrawBerryPriceHandler());
        handlerChain.handle(goodsContextHolder);
        Assertions.assertEquals(goodsContextHolder.getTotalPrice(),new BigDecimal("46.40"));
    }

    @Test
    @DisplayName("问题四")
    public void questionFourTest() {
        GoodsContextHolder goodsContextHolder = new GoodsContextHolder();
        int count = 5;
        goodsContextHolder.addShopingCart(new Apple(count), new Strawberry(count),new Mango(count));
        HandlerChain handlerChain = new HandlerChain();
        handlerChain.addHandler(new FullDiscountHandler());
        handlerChain.addHandler(new StrawBerryPriceHandler());
        handlerChain.handle(goodsContextHolder);
        BigDecimal totalPrice = goodsContextHolder.getTotalPrice();
        Assertions.assertEquals(totalPrice,new BigDecimal("182.00"));
    }
}
