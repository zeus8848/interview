package com.github.handler;
import com.github.handler.impl.BigDecimalScaleHandler;
import com.github.handler.impl.NormalPriceHandler;
import com.github.holder.GoodsContextHolder;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zeus
 * @date 2024/4/7
 * @description:
 */
public class HandlerChain {
    private List<GoodsPriceHandler> handlers = new ArrayList<>();
    public HandlerChain(){
        handlers.add(new BigDecimalScaleHandler());
        handlers.add(new NormalPriceHandler());
    }
    public void addHandler(GoodsPriceHandler handler){
        this.handlers.add(handler);
    }

    public void  handle(GoodsContextHolder goodsContextHolder){
        AnnotationAwareOrderComparator.sort(handlers);
        for (GoodsPriceHandler goodsPriceHandler : handlers) {
            goodsPriceHandler.handle(goodsContextHolder);
        }
    }

}
