package com.example.kmupbl3.domain;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class AdTagConstants {

    private static final BiMap<Integer, String> TAG_MAP = HashBiMap.create();

    public static final String TEENAGER_AND_BELOW = "10s-";
    public static final String TWENTIES = "20s";
    public static final String THIRTIES = "30s";
    public static final String FORTIES = "40s";
    public static final String FIFTIES = "50s";
    public static final String SIXTIES = "60s";
    public static final String SEVENTIES_AND_ABOVE = "70s+";
    public static final String MALE = "male";
    public static final String FEMALE = "female";

    static {
        TAG_MAP.put(1, TEENAGER_AND_BELOW);
        TAG_MAP.put(2, TWENTIES);
        TAG_MAP.put(3, THIRTIES);
        TAG_MAP.put(4, FORTIES);
        TAG_MAP.put(5, FIFTIES);
        TAG_MAP.put(6, SIXTIES);
        TAG_MAP.put(7, SEVENTIES_AND_ABOVE);
        TAG_MAP.put(10, MALE);
        TAG_MAP.put(11, FEMALE);
    }

    public static Integer getIdByTagName(String tagName) {
        return TAG_MAP.inverse().get(tagName);
    }

    public static String getTagNameById(int id) {
        return TAG_MAP.get(id);
    }
}


