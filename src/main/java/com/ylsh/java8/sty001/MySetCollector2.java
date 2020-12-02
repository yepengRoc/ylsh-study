package com.ylsh.java8.sty001;

import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class MySetCollector2<T> implements Collector<T, Set<T>,Map<T,T>> {

    @Override
    public Supplier<Set<T>> supplier() {
        System.out.println("supplier invoked");

        return HashSet<T>::new;
    }

    @Override
    public BiConsumer<Set<T>, T> accumulator() {
        System.out.println("accumulator invoked");
//        return Set<T>::add;
        return (set, item) -> {
            System.out.println("accumulator:" + set + "," + Thread.currentThread().getName());
            set.add(item);
        };
    }

    @Override
    public BinaryOperator<Set<T>> combiner() {
        System.out.println("combiner invodked");

        return (s1, s2) -> {
            System.out.println("s1:" + s1);
            System.out.println("s2:" + s2);
            s1.addAll(s2);
            return s1;
        };
    }

    @Override
    public Function<Set<T>, Map<T,T>> finisher() {
        System.out.println("finish invoked");

        return set ->{
           /* Map<T, T> map = new HashMap<>();
            set.stream().forEach(item -> map.put(item,item));
            return map; */
            Map<T, T> map = new TreeMap<>();
            set.stream().forEach(item -> map.put(item,item));
            return map;
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
//        return Collections.unmodifiableSet(EnumSet.of(Characteristics.UNORDERED));
//        return Collections.unmodifiableSet(EnumSet.of(Characteristics.UNORDERED,Characteristics.IDENTITY_FINISH));

        return Collections.unmodifiableSet(EnumSet.of(Characteristics.UNORDERED,Characteristics.CONCURRENT));//改为并发
    }
}
