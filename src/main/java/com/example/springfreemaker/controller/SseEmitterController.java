package com.example.springfreemaker.controller;

import com.example.springfreemaker.service.SseEmitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class SseEmitterController {

    @Autowired
    SseEmitterService sseEmitterService;

    @GetMapping("/emit-data-sets")
    public SseEmitter fetchData2()
    {
        SseEmitter emitter = new SseEmitter();

        ExecutorService executor = Executors.newSingleThreadExecutor();

        executor.execute(() ->
        {

//            List<DataSet> dataSets = dataSetService.findAll();

            try {
                for (int i=0; i <10; i++) {
                    randomDelay();
                    emitter.send("name" + i);
                }

                emitter.complete();

            } catch (IOException e) {
                emitter.completeWithError(e);
            }
        });
        executor.shutdown();
        return emitter;
    }

    private void randomDelay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
