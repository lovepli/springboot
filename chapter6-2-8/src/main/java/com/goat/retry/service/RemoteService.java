package com.goat.retry.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.remoting.RemoteAccessException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

/**
 * Created by 64274 on 2019/1/27.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/1/27---14:46
 */
@Service
public class RemoteService {

    private final static Logger logger = LoggerFactory.getLogger(RemoteService.class);


    /**
     @Retryable注解 被注解的方法发生异常时会重试
     value：指定发生的异常进行重试
     include：和 value 一样，默认空，当exclude也为空时，所有异常都重试
     exclude：指定异常不重试，默认空，当include也为空时，所有异常都重试
     maxAttemps：重试次数，默认3
     backoff：重试补偿机制，默认没有
    */
    @Retryable(value = { RemoteAccessException.class }, maxAttempts = 3, backoff = @Backoff(delay = 5000l, multiplier = 1))
    public void retryable() {
        logger.info(LocalTime.now()+" 进入 retryable()..............");
        throw new RemoteAccessException("RPC调用异常");
    }

    /**
     @Recover
     当重试到达指定次数时，被注解的方法将被回调，可以在该方法中进行日志处理。需要注意的是发生的异常和入参类型一致时才会回调。
    */
    @Recover
    public void recover(RemoteAccessException e) {
        System.out.println(LocalTime.now()+" 进入 recover()..............");
        logger.info(e.getMessage());
    }
}