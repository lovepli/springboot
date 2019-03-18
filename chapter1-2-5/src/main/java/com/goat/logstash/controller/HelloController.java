package com.goat.logstash.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 64274 on 2019/3/16.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/3/16---14:56
 */
@RestController
public class HelloController {

//    private final Logger logger = LoggerFactory.getLogger(getClass()) ;
private org.apache.log4j.Logger logger = Logger.getLogger(getClass());
    //   http://localhost:8125/hello
    @GetMapping("/hello")
    public String hello(){
        logger.debug("wahaha");
        return "wahaha";
    }

    //   http://localhost:8125/hello2
    @GetMapping("/hello2")
    public String hello2(){
       if (1>0)  throw new RuntimeException("123");
        return "wahaha";
    }


    //   http://localhost:8125/hello3
    @GetMapping("/hello3")
    public void hello3(){
        for(int i=0;i<100;i++) {
            logger.info("输出info  ");
            logger.debug("输出debug+skkkw嗡嗡嗡kw");
            logger.error("输出error  嗡嗡嗡我");
        }
    }
}
