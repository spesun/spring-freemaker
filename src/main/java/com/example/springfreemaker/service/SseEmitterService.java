package com.example.springfreemaker.service;

import com.example.springfreemaker.model.DataSet;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigInteger;
import java.util.*;

@Service
public class SseEmitterService
{
    private final List datasetList = new ArrayList<>();

    @PostConstruct
    public void setup() {
        createDataSets();
    }

    public List findAll() {
        return Collections.unmodifiableList(datasetList);
    }

    private Iterable createDataSets()
    {
        String name = "dummy text_";

        for (int i = 0; i < 5; i++) {
            this.datasetList.add( new DataSet(BigInteger.valueOf(i), name + i) );
        }
        return datasetList;
    }
}

