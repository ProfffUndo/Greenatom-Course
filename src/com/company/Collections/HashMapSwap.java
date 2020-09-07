package com.company.Collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapSwap {
    public static void main(String[] args) {
        HashMap<Integer,String> hashMap = new HashMap<>();
        hashMap.put(1,"Lance");
        hashMap.put(2,"Lewis");
        hashMap.put(3,"Seb");
        hashMap.put(4,"Seb");

        for (Map.Entry entry : hashMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " Value: "
                    + entry.getValue());
        }
        HashMap<String,Integer> newHashMap = swap(hashMap);
        for (Map.Entry entry : newHashMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " Value: "
                    + entry.getValue());
        }
    }

    public static <K,V> HashMap<V,K> swap(HashMap<K,V> hashMap){
        HashMap<V,K> newHashMap = new HashMap();
        for(Map.Entry<K,V> entry : hashMap.entrySet())
            newHashMap.put(entry.getValue(), entry.getKey());
        return newHashMap;
    }
}
