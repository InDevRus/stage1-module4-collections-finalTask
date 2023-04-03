package com.epam.mjc.collections.combined;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapFromKeysCreator {
    public Map<Integer, Set<String>> createMap(Map<String, Integer> sourceMap) {
        var result = new HashMap<Integer, Set<String>>();

        for (var key : sourceMap.keySet()) {
            result.putIfAbsent(key.length(), new HashSet<>());
            result.get(key.length()).add(key);
        }

        return result;
    }
}
