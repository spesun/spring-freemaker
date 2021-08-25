package com.example.springfreemaker;

import com.example.springfreemaker.service.SseEmitterService;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringFreemakerApplicationTests {

    @SpyBean
    SseEmitterService sseEmitterService;

    @Test
    public void contextLoads() {
        Mockito.when(sseEmitterService.findAll()).thenReturn(Lists.newArrayList("111"));
        System.out.println(sseEmitterService.findAll());
    }


}
