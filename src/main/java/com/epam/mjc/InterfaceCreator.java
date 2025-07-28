package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return new Predicate<List<String>>() {
            @Override
            public boolean test(List<String> strings) {
                for (String string : strings) {
                    if(!Character.isUpperCase(string.charAt(0))) {
                        return false;
                    }
                }
                return true;
            }
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return new Consumer<List<Integer>>() {
            @Override
            public void accept(List<Integer> integers) {
                int len = integers.size();
                for (int i = 0; i < len; i++) {
                    if(integers.get(i) %2 == 0) {
                        integers.add(integers.get(i));
                    }
                }
            }
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return new Supplier<List<String>>() {
            @Override
            public List<String> get() {
                List<String> list = new ArrayList<>();
                for (String value : values) {
                    if(!Character.isUpperCase(value.charAt(0))
                            || value.split(" ").length <= 3
                            || value.charAt(value.length()-1) != '.') {
                        continue;
                    }
                    else {
                        list.add(value);
                    }
                }
                return list;
            }
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return new Function<List<String>, Map<String, Integer>>() {
            @Override
            public Map<String, Integer> apply(List<String> strings) {
                Map<String, Integer> map = new HashMap<>();
                for (String string : strings) {
                    map.put(string, string.length());
                }
                return map;
            }
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return new BiFunction<List<Integer>, List<Integer>, List<Integer>>() {
            @Override
            public List<Integer> apply(List<Integer> integers, List<Integer> integers2) {
                List<Integer> list = new ArrayList<>();
                list.addAll(integers);
                list.addAll(integers2);
                return list;
            }
        };
    }
}
