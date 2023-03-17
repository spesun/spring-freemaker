package com.example.springfreemaker.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class SpringDeferredResultController {

    @GetMapping("/handleReqDefResult")
    public DeferredResult<String> handleReqDefResult(){
        long timeoutValue = 4700;//超时时间.
        DeferredResult<String> deferredResult = new DeferredResult<>(timeoutValue);

        new Thread(){
            @Override
            public void run() {
                //执行耗时的逻辑
                try {
                    //休眠n秒钟进行模拟业务代码.
                    TimeUnit.SECONDS.sleep(new Random().nextInt(7));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //返回结果.
                deferredResult.setResult("love ~ "+new Date());
            }
        }.start();

        log.info("deferredResult new {}", deferredResult.toString());
        return deferredResult;
    }
}
