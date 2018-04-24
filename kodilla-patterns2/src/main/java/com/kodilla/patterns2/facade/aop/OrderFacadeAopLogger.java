package com.kodilla.patterns2.facade.aop;

import com.kodilla.patterns2.facade.api.OrderDto;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class OrderFacadeAopLogger {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderFacadeAopLogger.class);


    @Before("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))"
    + " && args(order,userId) && target(object)")
    public void logOrderEvent(OrderDto order, Long userId, Object object) {
        LOGGER.info(" ==> Class: " + object.getClass().getName());
        LOGGER.info(" ==> Args: userId=" + userId + ", order=" + order.getItems().toString());
    }
}
