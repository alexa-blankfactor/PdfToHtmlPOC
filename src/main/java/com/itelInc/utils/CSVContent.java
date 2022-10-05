package com.itelInc.utils;

import com.google.common.collect.ImmutableMap;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class CSVContent {

    public static List<Map<String,String>> getValue(String fileName){

        CSVParser csvParser= new CSVParserBuilder().withSeparator(';').build();
        List<String[]> values;
        Map<String,String> mapValues = new HashMap<>();
        List<Map<String,String>> endValue = new ArrayList<>();

        try {
            values = new CSVReaderBuilder(new FileReader(fileName)).withCSVParser(csvParser).build().readAll();
            values.stream().skip(1).forEach(value ->{
                Arrays.stream(value).toList().forEach(withCounter((i,x)->{
                    mapValues.put((values.get(0))[i],x);

                }));
                endValue.add(ImmutableMap.copyOf(mapValues));
                mapValues.clear();
            });
            return endValue;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }
    }
    public static  <T> Consumer<T> withCounter(BiConsumer<Integer, T> consumer) {
        AtomicInteger counter = new AtomicInteger(0);
        return item -> consumer.accept(counter.getAndIncrement(), item);
    }
}
