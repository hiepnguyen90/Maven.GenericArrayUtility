package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {
    //Iniitialize Generic Array Type
    private final T[] array;

    public ArrayUtility(T[] array) {
        this.array = array;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        Integer counter = 0;

        for (T t : arrayToMerge) {
            if (t.equals(valueToEvaluate)) {
                counter++;
            }
        }

        for (T t : array) {
            if (t.equals(valueToEvaluate)) {
                counter++;
            }
        }
        return counter;
    }

    public T getMostCommonFromMerge(T[] valueToEvaluate) {
        // Record key and max number of occurrences
        T keyMax = null;
        Integer maxNum = 0;
        // Iterate through the array

        HashMap<T, Integer> map = new HashMap<>();
        // If map already recorded number of instances for a certain key, add 1
        for(T t:array){
            T key = t;
            if(map.containsKey(key)) {
                Integer value = map.get(key);
                map.put(key, value+1);
            } else {
                map.put(key, 1);
            }
            for (Map.Entry<T, Integer> entry : map.entrySet()){
                if(entry.getValue() > maxNum) {
                    maxNum = entry.getValue();
                    keyMax = entry.getKey();
                }
            }
        }

        return keyMax;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {

        Integer counter = 0;

        for (T t : array) {
            if (t.equals(valueToEvaluate)) {
                counter++;
            }
        }
        return counter;
    }

    public T[] removeValue(T valueToRemove) {

        Integer counter = array.length;

        for(int i = 0; i < array.length; i++){
            if(array[i].equals(valueToRemove)){
                counter--;
            }
        }
    Class arrayClass = array.getClass();
    Class component = arrayClass.getComponentType();

    T[] newArray = (T[]) Array.newInstance(component,counter);

        Integer newCount = 0;

        for(T t : array){
            if(!t.equals(valueToRemove)){
                newArray[newCount] = t;
                newCount++;
            }
        }
        return newArray;

    }
}