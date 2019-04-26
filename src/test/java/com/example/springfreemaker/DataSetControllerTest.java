package com.example.springfreemaker;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigInteger;
import java.util.Arrays;

import com.example.springfreemaker.controller.SseEmitterController;
import com.example.springfreemaker.model.DataSet;
import com.example.springfreemaker.service.SseEmitterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.JsonPathExpectationsHelper;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

//TODO 不能运行
//参考：https://howtodoinjava.com/spring-boot2/spring-async-controller-sseemitter/
@RunWith(SpringRunner.class)
@WebMvcTest(SseEmitterController.class)
public class DataSetControllerTest
{
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SseEmitterService sseEmitterService;

    @Test
    public void foo() throws Exception
    {
        Mockito.when(sseEmitterService.findAll())
                .thenReturn(Arrays.asList(new DataSet(BigInteger.valueOf(1), "data")));

        MvcResult mvcResult = mockMvc.perform(get("/emit-data-sets"))
                .andExpect(request().asyncStarted())
                .andDo(MockMvcResultHandlers.log())
                .andReturn();

        mockMvc.perform(asyncDispatch(mvcResult))
                .andDo(MockMvcResultHandlers.log())
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/event-stream;charset=UTF-8"));

        String event = mvcResult.getResponse().getContentAsString();
        event = event.replaceAll("data:", "");
        event = event.replaceAll("\\n", "");

        new JsonPathExpectationsHelper("$.id").assertValue(event, "1");
        new JsonPathExpectationsHelper("$.name").assertValue(event, "data");
    }
}
