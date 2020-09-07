package com.company.Collections;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class Methods {

    public static void main(String[] args) {
        String example="example";
        ArrayList<String> arrayList = new ArrayList<String>();
        LinkedList<String> linkedList = new LinkedList<String>();
        TreeSet<String> treeSet = new TreeSet<String>();
        HashSet<String> hashSet = new HashSet<String>();
        long startTime;
        long endTime;
        System.out.println("Добавление");
        System.out.print("ArrayList\t");
        startTime = System.currentTimeMillis();
        for (int i=0; i<100000; i++){
            arrayList.add(example+i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime-startTime) + "ms");
        System.out.print("LinkedList\t");
        startTime = System.currentTimeMillis();
        for (int i=0; i<100000; i++){
            linkedList.add(example+i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime-startTime) + "ms");
        System.out.print("TreeSet\t\t");
        startTime = System.currentTimeMillis();
        for (int i=0; i<100000; i++){
            treeSet.add(example+i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime-startTime) + "ms");
        System.out.print("HashSet\t\t");
        startTime = System.currentTimeMillis();
        for (int i=0; i<100000; i++) {
            hashSet.add(example);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime-startTime) + "ms");
        System.out.println();


        System.out.println("Поиск");
        System.out.print("ArrayList\t");
        startTime = System.currentTimeMillis();
        for (int i=0; i<100000; i++){
            arrayList.contains(example+i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime-startTime) + "ms");
        System.out.print("LinkedList\t");
        startTime = System.currentTimeMillis();
        for (int i=0; i<100000; i++){
            linkedList.contains(example+i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime-startTime) + "ms");
        System.out.print("TreeSet\t\t");
        startTime = System.currentTimeMillis();
        for (int i=0; i<100000; i++){
            treeSet.contains(example+i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime-startTime) + "ms");
        System.out.print("HashSet\t\t");
        startTime = System.currentTimeMillis();
        for (int i=0; i<100000; i++) {
            hashSet.contains(example);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime-startTime) + "ms");
        System.out.println();


        System.out.println("Удаление");
        System.out.print("ArrayList\t");
        startTime = System.currentTimeMillis();
        for (int i=0; i<100000; i++){
            arrayList.remove(example+i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime-startTime) + "ms");
        System.out.print("LinkedList\t");
        startTime = System.currentTimeMillis();
        for (int i=0; i<100000; i++){
            linkedList.remove(example+i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime-startTime) + "ms");
        System.out.print("TreeSet\t\t");
        startTime = System.currentTimeMillis();
        for (int i=0; i<100000; i++){
            treeSet.remove(example+i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime-startTime) + "ms");
        System.out.print("HashSet\t\t");
        startTime = System.currentTimeMillis();
        for (int i=0; i<100000; i++) {
            hashSet.remove(example);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime-startTime) + "ms");

    }

}
